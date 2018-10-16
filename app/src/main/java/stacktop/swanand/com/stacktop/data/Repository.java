package stacktop.swanand.com.stacktop.data;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stacktop.swanand.com.stacktop.AppExecutors;
import stacktop.swanand.com.stacktop.data.database.ItemDao;
import stacktop.swanand.com.stacktop.data.network.ApiService;
import stacktop.swanand.com.stacktop.datamodel.Item;
import stacktop.swanand.com.stacktop.datamodel.Post;

public class Repository {

    private static final String LOG_TAG = Repository.class.getSimpleName();


    // For Singleton instantiation
    private static final Object LOCK = new Object();

    private  static Repository sInstance;

    private final ItemDao mItemDao;
    private final ApiService mApiService;
    private final AppExecutors mExecutors;
    private boolean mInitialized = false;

    List<Item> questions = new ArrayList<>();
    private Repository(ItemDao itemDao,
                               ApiService apiService,
                               AppExecutors executors) {
        mItemDao = itemDao;
        mApiService = apiService;
        mExecutors = executors;

        final Map<String, String> params = new HashMap<>();
        params.put("order","desc");
        params.put("sort","activity");
        params.put("site","stackoverflow");

        Call<Post> call=mApiService.getQuestions(params);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                mExecutors.diskIO().execute(()->{

                    itemDao.bulkInsert(response.body().getItems());


                    Log.d("DBTEST","New values inserted");

                });


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });


    }

    public synchronized static Repository getInstance(
            ItemDao itemDao,
            ApiService apiService,
            AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new Repository(itemDao, apiService,
                        executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public List<Item> getQuestions() {

        mExecutors.diskIO().execute(()->{

          questions =mItemDao.getAll();


        });
        return  questions;
    }
}
