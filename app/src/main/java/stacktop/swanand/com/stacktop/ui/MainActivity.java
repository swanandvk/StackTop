package stacktop.swanand.com.stacktop.ui;
import android.os.Bundle;
import javax.inject.Inject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import stacktop.swanand.com.stacktop.R;
import stacktop.swanand.com.stacktop.data.Repository;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Inject
    Repository repository;

    @Inject
    PostAdapter postAdapter;

    MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(postAdapter);
        MainActivityViewModelFactory factory = new MainActivityViewModelFactory(repository);
        mViewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel.class);
        mViewModel.getQuestions().observe(this, Items -> {
            postAdapter.addPosts(Items);

        });

    }
}
