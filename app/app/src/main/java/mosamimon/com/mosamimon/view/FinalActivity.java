package mosamimon.com.mosamimon.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mosamimon.com.mosamimon.R;
import mosamimon.com.mosamimon.rest.ApiResponse;

public class FinalActivity extends AppCompatActivity {

    private static final String TAG = FinalActivity.class.getSimpleName();
    private ApiResponse customerResponse;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.number)
    TextView number;

    @BindView(R.id.correctResult)
    View correctResult;

    @BindView(R.id.wrongResult)
    View wrongResult;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @BindView(R.id.backBtn)
    View backBtn;

    @BindView(R.id.finalLink)
    View finalLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        toolbarTitle.setText(R.string.result_screen_title);
        setSupportActionBar(toolbar);
        customerResponse = getIntent().getParcelableExtra("extra");
        try {
            name.setText(customerResponse.result.get(0).fullname);
            number.setText(customerResponse.result.get(0).customerID);
            if ("Verified".equalsIgnoreCase(customerResponse.result.get(0).verifiedStatus)) {
                correctResult.setVisibility(View.VISIBLE);
            } else {
                wrongResult.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        finalLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dnet.so/mosamimon.com/cp/invoices/listall"));
                startActivity(browserIntent);
            }
        });

    }

    private void login(String email, String password) {
//        progressBar.setVisibility(View.VISIBLE);
//        API.member().login(getRequestBody(email), getRequestBody(password)).enqueue(new retrofit2.Callback<CustomerResponse>() {
//            @Override
//            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
//                progressBar.setVisibility(View.GONE);
//                if (response.code() == 200) {
//                    startActivity(new Intent(FinalActivity.this, ScanCodeActivity.class));
//                } else {
//                    Toast.makeText(FinalActivity.this, "fail", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CustomerResponse> call, Throwable throwable) {
//                progressBar.setVisibility(View.GONE);
//                Log.e(TAG, throwable.getMessage());
//                Toast.makeText(FinalActivity.this, "fail", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
