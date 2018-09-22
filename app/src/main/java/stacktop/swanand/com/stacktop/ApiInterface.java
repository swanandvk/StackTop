package stacktop.swanand.com.stacktop;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {

    @GET("questions")
    Call<Post> getQuestions(@QueryMap Map<String,String> params);
}
