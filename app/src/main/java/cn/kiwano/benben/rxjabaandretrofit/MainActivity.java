package cn.kiwano.benben.rxjabaandretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.security.auth.Subject;

import cn.kiwano.benben.rxjabaandretrofit.model.MovieModel;
import cn.kiwano.benben.rxjabaandretrofit.rxjabaretrofit.entity.SubjectPost;
import cn.kiwano.benben.rxjabaandretrofit.rxjabaretrofit.listener.HttpOnNextListener;
import cn.kiwano.benben.rxjabaandretrofit.rxjabaretrofit.subscribers.ProgressSubscriber;
import cn.kiwano.benben.rxjabaandretrofit.service.MoveService;
import cn.kiwano.benben.rxjabaandretrofit.utils.HttpUtil;
import cn.kiwano.benben.rxjabaandretrofit.rxjabaretrofit.RetrofitUtils;
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
                getMovie3();
            }
        });
    }







    /*完美简化版*/
    public void getMovie3() {
        SubjectPost postEntity = new SubjectPost(new ProgressSubscriber(simpleOnNextListener, this), true);
        RetrofitUtils manager = RetrofitUtils.getInstance();
        manager.doHttpDeal(postEntity);
    }

    HttpOnNextListener simpleOnNextListener = new HttpOnNextListener<MovieModel.ResultBean>() {
        @Override
        public void onNext(MovieModel.ResultBean resultBean) {
            mContent.setText("已封装:\n"+resultBean.getAct()+"\n"+resultBean.getAct_s()+
                    "\n"+resultBean.getYear()+"\n"+resultBean.getVdo_status()+
                    "\n"+resultBean.getTitle()+"\n"+resultBean.getDesc());
        }
    };
}
