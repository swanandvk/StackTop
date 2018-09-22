package stacktop.swanand.com.stacktop;

import android.app.Activity;
import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StackApplication extends Application {


  public static StackApplication get(Activity activity)
  {
    return (StackApplication) activity.getApplication();
  }

  private ApiInterface apiInterface;
  private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder=new GsonBuilder();
        Gson gson=gsonBuilder.create();


        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.stackexchange.com/2.2/")
                .build();

        apiInterface=retrofit.create(ApiInterface.class);

        picasso=new Picasso.Builder(this)
                .build();
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
