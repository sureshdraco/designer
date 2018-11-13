package mosamimon.com.mosamimon.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import mosamimon.com.mosamimon.R;
import mosamimon.com.mosamimon.rest.API;
import mosamimon.com.mosamimon.rest.ApiResponse;
import mosamimon.com.mosamimon.rest.CustomerResponse;
import retrofit2.Call;
import retrofit2.Response;

import static android.telephony.MbmsDownloadSession.RESULT_CANCELLED;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
        qrCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

                    startActivityForResult(intent, 0);
                } catch (Exception e) {
                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW, marketUri);
                    startActivity(marketIntent);
                }
            }
        });
        qrSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                qrCode.setText(contents);

            }
            if (resultCode == RESULT_CANCELLED) {
                //handle cancel
            }
        }
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
