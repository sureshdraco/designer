package mosamimon.com.mosamimon.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import mosamimon.com.mosamimon.R;
import mosamimon.com.mosamimon.rest.API;
import mosamimon.com.mosamimon.rest.LoginResponse;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
	
	private static final String TAG = MainActivity.class.getSimpleName();
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				login("", "");
			}
		});
	}
	
	private void login(String email, String password) {
		API.member().login(email, password).enqueue(new retrofit2.Callback<LoginResponse>() {
			@Override
			public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
				Toast.makeText(MainActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
				final LoginResponse loginResponse = response.body();
				
			}
			
			@Override
			public void onFailure(Call<LoginResponse> call, Throwable throwable) {
				Log.e(TAG, throwable.toString());
				progressBar.setVisibility(View.GONE);
				Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}
	
}
