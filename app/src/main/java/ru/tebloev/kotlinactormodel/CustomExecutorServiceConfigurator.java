package ru.tebloev.kotlinactormodel;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.typesafe.config.Config;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import akka.dispatch.DispatcherPrerequisites;
import akka.dispatch.ExecutorServiceConfigurator;
import akka.dispatch.ExecutorServiceFactory;
import akka.dispatch.ThreadPoolConfig;
import akka.dispatch.ThreadPoolConfigBuilder;

/**
 * @author Tebloev Vladimir
 */

public class CustomExecutorServiceConfigurator extends ExecutorServiceConfigurator {

    public CustomExecutorServiceConfigurator(Config config, DispatcherPrerequisites prerequisites) {
        super(config, prerequisites);
    }

    @Override
    public ExecutorServiceFactory createExecutorServiceFactory(String id, ThreadFactory threadFactory) {
        return new ExecutorServiceFactoryImpl();
    }

    private class ExecutorServiceFactoryImpl implements ExecutorServiceFactory {

        @Override
        public ExecutorService createExecutorService() {
            return new AbstractExecutorService() {

                private final Handler handler = new Handler(Looper.getMainLooper());

                @Override
                public void shutdown() {}

                @NonNull
                @Override
                public List<Runnable> shutdownNow() {
                    return null;
                }

                @Override
                public boolean isShutdown() {
                    return false;
                }

                @Override
                public boolean isTerminated() {
                    return false;
                }

                @Override
                public boolean awaitTermination(long timeout, @NonNull TimeUnit unit) throws InterruptedException {
                    return false;
                }

                @Override
                public void execute(@NonNull Runnable command) {
                    handler.post(command);
                }
            };
        }
    }
}
