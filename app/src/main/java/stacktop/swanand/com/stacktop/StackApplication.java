package stacktop.swanand.com.stacktop;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stacktop.swanand.com.stacktop.di.ApiInterfaceModule;
import stacktop.swanand.com.stacktop.di.ContextModule;
import stacktop.swanand.com.stacktop.di.DaggerStackApplicationComponent;
import stacktop.swanand.com.stacktop.di.NetworkModule;
import stacktop.swanand.com.stacktop.di.PicassoModule;
import stacktop.swanand.com.stacktop.di.StackApplicationComponent;
import timber.log.Timber;

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

        Timber.plant(new Timber.DebugTree());

        StackApplicationComponent stackApplicationComponent= DaggerStackApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();



        apiInterface=stackApplicationComponent.getApiInterface();

        picasso=stackApplicationComponent.getPicasso();



    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
