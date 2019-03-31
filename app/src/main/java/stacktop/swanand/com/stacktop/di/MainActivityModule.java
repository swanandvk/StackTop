package stacktop.swanand.com.stacktop.di;

import android.content.Context;

import com.squareup.picasso.Picasso;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;
import stacktop.swanand.com.stacktop.data.Repository;
import stacktop.swanand.com.stacktop.datamodel.Post;
import stacktop.swanand.com.stacktop.ui.MainActivity;
import stacktop.swanand.com.stacktop.ui.MainActivityViewModel;
import stacktop.swanand.com.stacktop.ui.MainActivityViewModelFactory;
import stacktop.swanand.com.stacktop.ui.PostAdapter;

@Module
public class MainActivityModule {


    @Provides
    MainActivity provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    PostAdapter providePostAdapter(Context context, Picasso picasso){
        return new PostAdapter(context,picasso);
    }


}