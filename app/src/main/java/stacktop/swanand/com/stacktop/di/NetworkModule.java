package stacktop.swanand.com.stacktop.di;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @StackApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor(){
       HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });

       interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
       return interceptor;
    }

    @Provides
    @StackApplicationScope
    public Cache cache(File cachefile){
        return new Cache(cachefile,10* 1000 * 1000); // 10MB cache
    }

    @Provides
    @StackApplicationScope
    public File cachefile(Context context){
       return new File(context.getCacheDir(),"okhttp_cache");

    }
    @Provides
    @StackApplicationScope
   public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,Cache cache){

       return new OkHttpClient.Builder()
               .addInterceptor(httpLoggingInterceptor)
               .cache(cache)
               .build();
   }
}
