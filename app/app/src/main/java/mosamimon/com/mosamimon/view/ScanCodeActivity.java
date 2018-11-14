package mosamimon.com.mosamimon.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mosamimon.com.mosamimon.R;
import mosamimon.com.mosamimon.rest.API;
import mosamimon.com.mosamimon.rest.ApiResponse;
import retrofit2.Call;
import retrofit2.Response;

public class ScanCodeActivity extends AppCompatActivity {

    private static final String TAG = ScanCodeActivity.class.getSimpleName();
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.qrCapture)
    View qrCapture;

    @BindView(R.id.qrSubmit)
    View qrSubmit;

    @BindView(R.id.qrCode)
    EditText qrCode;

    @BindView(R.id.webLink)
    View webLink;

    @BindView(R.id.companyName)
    TextView companyName;
    private ApiResponse apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleScannerActivity.code = "";
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
        apiResponse = getIntent().getParcelableExtra("extra");
        try {
            companyName.setText(apiResponse.result.get(0).companyNane);
        } catch (Exception ignored) {
        }
        qrCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanCodeActivity.this, SimpleScannerActivity.class);
                startActivity(intent);
            }
        });
        qrSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qrCodeStr = qrCode.getText().toString();
                if (TextUtils.isEmpty(qrCodeStr)) {
                    qrCode.setError("Cannot be empty!");
                    return;
                }
                qrSubmit(qrCode.getText().toString());
            }
        });
        webLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.msammon.com"));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCode.setText(SimpleScannerActivity.code);
    }

    private void qrSubmit(String code) {
        progressBar.setVisibility(View.VISIBLE);
        API.member().get_member(code).enqueue(new retrofit2.Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(ScanCodeActivity.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                if (response.code() == 200) {
                    Intent intent = new Intent(ScanCodeActivity.this, FinalActivity.class);
                    intent.putExtra("extra", response.body());
                    startActivity(intent);
                } else {
                    Toast.makeText(ScanCodeActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                progressBar.setVisibility(View.GONE);
                Log.e(TAG, throwable.getMessage());
                Toast.makeText(ScanCodeActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
