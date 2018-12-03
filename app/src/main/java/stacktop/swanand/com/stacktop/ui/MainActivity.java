package stacktop.swanand.com.stacktop.ui;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import stacktop.swanand.com.stacktop.AppExecutors;
import stacktop.swanand.com.stacktop.R;
import stacktop.swanand.com.stacktop.data.Repository;
import stacktop.swanand.com.stacktop.data.database.AppDatabase;
import stacktop.swanand.com.stacktop.data.database.ItemDao;
import stacktop.swanand.com.stacktop.data.network.ApiService;

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

        recyclerView = findViewById(R.id.recyclerview);

        final PostAdapter postAdapter = new PostAdapter(this, picasso);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(postAdapter);

        database = AppDatabase.getInstance(getApplicationContext());
        itemDao = database.itemDao();
        executors = AppExecutors.getInstance();
        Repository repository = Repository.getInstance(itemDao, apiInterface, executors);


        MainActivityViewModelFactory factory = new MainActivityViewModelFactory(repository);

        mViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel.class);

        mViewModel.getQuestions().observe(this, Items -> {
            postAdapter.addPosts(Items);

        });


    }
}
