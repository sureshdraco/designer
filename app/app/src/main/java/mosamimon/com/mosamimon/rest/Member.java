package mosamimon.com.mosamimon.rest;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Member {
	//MOVIE SEARCH AUTOCOMPLETE
	@POST("/login")
	Call<LoginResponse> login(@Query("email") String email, @Query("password") String password);

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
