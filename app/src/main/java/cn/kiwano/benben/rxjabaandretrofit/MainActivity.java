package cn.kiwano.benben.rxjabaandretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        TextView mContent = (TextView) findViewById(R.id.main_content);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindData();
            }
        });
    }

    private void bindData() {
        RetrofitBuilder.get()
                .create(MoveService.class)
                .getToMovie(Constant.KEY,"谍影重重4")
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        Log.i(TAG, "成功");
                        MovieModel moveBean = response.body();
                        Log.i(TAG, "onResponse: "+moveBean);
                        Log.i("jam", "========================================" + moveBean.getReason());
                        Log.i("jam", "========================================" + moveBean.getResult());
                        Log.i("jam", "========================================" + moveBean.getError_code());

                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {
                        Log.i(TAG, "失败"+t.getMessage());
                    }
                });

    }


}
