package mosamimon.com.mosamimon.rest;

import com.google.gson.Gson;

import mosamimon.com.mosamimon.Config;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {
	private static <T> T builder(Class<T> endpoint) {
		return new Retrofit.Builder()
			.baseUrl(Config.API_BASE_URL)
			.addConverterFactory(GsonConverterFactory.create(new Gson()))
			.build()
			.create(endpoint);
	}
	
	public static Member member() {
		return builder(Member.class);
	}
}
