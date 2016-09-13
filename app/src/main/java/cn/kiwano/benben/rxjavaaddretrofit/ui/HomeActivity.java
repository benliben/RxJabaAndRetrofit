package cn.kiwano.benben.rxjavaaddretrofit.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import cn.kiwano.benben.rxjabaandretrofit.Constant;
import cn.kiwano.benben.rxjabaandretrofit.R;

import cn.kiwano.benben.rxjabaandretrofit.MovieModel;
import cn.kiwano.benben.rxjavaaddretrofit.entity.SubjectPost;
import cn.kiwano.benben.rxjavaaddretrofit.http.HttpManager;
import cn.kiwano.benben.rxjavaaddretrofit.listener.HttpOnNextListener;
import cn.kiwano.benben.rxjavaaddretrofit.subscribers.ProgressSubscriber;

/**
 * Created by LiYuanxiong on 2016/9/12 16:26.
 * Desribe:
 */
public class HomeActivity extends BaseActivity {
    @Bind(R.id.home_content)
    TextView mContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.home_button)
    public void onClick() {
        bindData();
    }

    private void bindData() {
        SubjectPost postEntity = new SubjectPost(new ProgressSubscriber(simpleOnNextListener, this), Constant.KEY, "谍影重重4");
        HttpManager managet = HttpManager.getInstance();
        managet.doHttpDeal(postEntity);
    }

    HttpOnNextListener simpleOnNextListener = new HttpOnNextListener<List<MovieModel.ResultBean>>() {
        @Override
        public void onNext(List<MovieModel.ResultBean> resultBean) {
            mContent.setText("已封装：\n" + resultBean.toString());
        }
    };
}
