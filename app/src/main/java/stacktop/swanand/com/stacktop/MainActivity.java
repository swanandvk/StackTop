package stacktop.swanand.com.stacktop;

import android.os.Bundle;


import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Inject
    ApiInterface apiInterface;
    @Inject
    Picasso picasso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recyclerview);


        final PostAdapter postAdapter=new PostAdapter(this,picasso);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(postAdapter);

        final Map<String, String> params = new HashMap<>();
        params.put("order","desc");
        params.put("sort","activity");
        params.put("site","stackoverflow");

       Call<Post> call=apiInterface.getQuestions(params);
       call.enqueue(new Callback<Post>() {
           @Override
           public void onResponse(Call<Post> call, Response<Post> response) {

               postAdapter.addPosts(response.body().getItems());
               postAdapter.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<Post> call, Throwable t) {

           }
       });



    }
}
