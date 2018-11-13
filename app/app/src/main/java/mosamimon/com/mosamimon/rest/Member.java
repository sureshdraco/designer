package mosamimon.com.mosamimon.rest;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Member {
    @Multipart
    @POST("user/login")
    Call<LoginResponse> login(@Part("email") RequestBody email, @Part("password") RequestBody password);


    @GET("member/get_member")
    Call<LoginResponse> get_member(@Query("customer_id") String customerId);

//	//TOP RATED MOVIES
//	@GET("")
//	Call<MoviesResponse> topRated(@Query("api_key") String apiKey);
//
//	//MOVIE DETAIL
//	@GET("/3/movie/{id}")
//	Call<MovieResponse> movieDetails(@Path("id") int movieID, @Query("api_key") String apiKey);
//
//	//MOVIE IMAGES
//	@GET("/movie/{id}/images")
//	Call<ImagesResponse> movieImages(@Query("api_key") String apiKey, @Path("id") int movieID);
}
