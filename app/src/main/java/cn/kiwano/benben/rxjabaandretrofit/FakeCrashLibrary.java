package cn.kiwano.benben.rxjabaandretrofit;

import android.util.Log;

/**
 * Created by LiYuanxiong on 2016/9/13 11:56.
 * Desribe:
 */
public class FakeCrashLibrary {
    public static void log(int priority, String tag, String message) {
        // TODO add log entry to circular buffer.
        Log.d(tag, "xxxxxxxxxxxxxxxxxxxxxxxxxx"+message + ":" + priority);
    }

    public static void logWarning(Throwable t) {
        // TODO report non-fatal warning.
    }

    public static void logError(Throwable t) {
        // TODO report non-fatal error.
    }

    private FakeCrashLibrary() {
        throw new AssertionError("No instances.");
    }
}
