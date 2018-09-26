package stacktop.swanand.com.stacktop.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stacktop.swanand.com.stacktop.ApiInterface;

@Module(includes = NetworkModule.class)
public class ApiInterfaceModule {

    @Provides
    @StackApplicationScope
    public ApiInterface apiInterface(Retrofit retrofit){

        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @StackApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @StackApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
    return  new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.stackexchange.com/2.2/")
                .build();


    }
}
