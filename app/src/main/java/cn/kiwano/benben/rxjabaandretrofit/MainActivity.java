package cn.kiwano.benben.rxjabaandretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import cn.kiwano.benben.rxjabaandretrofit.model.MovieModel;
import cn.kiwano.benben.rxjabaandretrofit.service.MoveService;
import cn.kiwano.benben.rxjabaandretrofit.utils.HttpUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    private TextView mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        mContent = (TextView) findViewById(R.id.main_content);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMovie();
                getMovie1();
                getMovie2();
            }
        });
    }


    public void getMovie() {
        String baseUrl = "http://op.juhe.cn/onebox/movie/";

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MoveService moveService = retrofit.create(MoveService.class);
        Call<MovieModel> call = moveService.getToMovie("593952e8101d489ddef22d152d6d41c0", "谍影重重4");
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
               mContent.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                mContent.setText(t.getMessage());
            }
        });

    }

    public void getMovie1() {
        String baseUrl = "http://op.juhe.cn/onebox/movie/";

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        final MoveService moveService = retrofit.create(MoveService.class);

        moveService.getToMovie2("593952e8101d489ddef22d152d6d41c0", "谍影重重4")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieModel>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this,"Get Top Movie",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mContent.setText(e.getMessage());
                    }

                    @Override
                    public void onNext(MovieModel movieModel) {
                        mContent.setText(movieModel.toString());
                    }
                });
    }

    public void getMovie2() {
        Subscriber subscriber = new Subscriber<MovieModel>(){

            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this,"Get Top Movie",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                mContent.setText(e.getMessage());
            }

            @Override
            public void onNext(MovieModel movieModel) {
                mContent.setText(movieModel.toString());
            }
        };
        HttpUtil.getInstance().getToMovie(subscriber,"593952e8101d489ddef22d152d6d41c0", "谍影重重4");
    }
}
