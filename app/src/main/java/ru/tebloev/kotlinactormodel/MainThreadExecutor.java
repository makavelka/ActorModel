package ru.tebloev.kotlinactormodel;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * @author Tebloev Vladimir
 */

class MainThreadExecutor implements Executor {
    private final Handler mHandler;
    public MainThreadExecutor(Handler optionalHandler) {
        mHandler = optionalHandler != null ? optionalHandler : new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable command) {
        mHandler.post(command);
    }
}