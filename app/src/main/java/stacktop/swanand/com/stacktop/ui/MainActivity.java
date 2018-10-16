package stacktop.swanand.com.stacktop.ui;

import android.os.Bundle;
import android.util.Log;


import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stacktop.swanand.com.stacktop.AppExecutors;
import stacktop.swanand.com.stacktop.data.Repository;
import stacktop.swanand.com.stacktop.data.database.AppDatabase;
import stacktop.swanand.com.stacktop.data.database.ItemDao;
import stacktop.swanand.com.stacktop.data.network.ApiService;
import stacktop.swanand.com.stacktop.datamodel.Item;
import stacktop.swanand.com.stacktop.datamodel.Post;
import stacktop.swanand.com.stacktop.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Inject
    ApiService apiInterface;
    @Inject
    Picasso picasso;
    AppDatabase database;
    ItemDao itemDao;
    AppExecutors executors;

    private MainActivityViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);

        final PostAdapter postAdapter=new PostAdapter(this,picasso);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(postAdapter);

        database = AppDatabase.getInstance(getApplicationContext());
        itemDao = database.itemDao();
        executors =AppExecutors.getInstance();
        Repository repository = Repository.getInstance(itemDao,apiInterface,executors);


        MainActivityViewModelFactory factory =new MainActivityViewModelFactory(repository);

        mViewModel= ViewModelProviders.of(this,factory).get(MainActivityViewModel.class);

       executors =AppExecutors.getInstance();
       executors.diskIO().execute(()->{

           List<Item> data = mViewModel.getQuestions();

           executors.mainThread().execute(()->{
               postAdapter.addPosts(data);

           });
       });


    }
}
