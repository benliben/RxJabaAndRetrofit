package cn.kiwano.benben.rxjabaandretrofit;

import android.app.Application;
import android.util.Log;

import timber.log.Timber;

/**
 * Created by LiYuanxiong on 2016/9/13 11:56.
 * Desribe:
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        new RetrofitBuilder
                .Builder()
                .baseUrl(Constant.BASE_URL);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReporttingTree());
        }
    }


    /**
     * 日志报告
     */
    private static class CrashReporttingTree extends Timber.Tree {

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }
            FakeCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
