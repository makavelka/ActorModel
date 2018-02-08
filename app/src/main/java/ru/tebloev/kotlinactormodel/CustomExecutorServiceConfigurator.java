package ru.tebloev.kotlinactormodel;

import com.typesafe.config.Config;

import java.util.concurrent.ThreadFactory;

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
        return createThreadPoolConfigBuilder().createExecutorServiceFactory(id, threadFactory);
    }

    private ThreadPoolConfig createThreadPoolConfigBuilder() {
        ThreadPoolConfigBuilder builder =
                new ThreadPoolConfigBuilder(new ThreadPoolConfig(ThreadPoolConfig.defaultAllowCoreThreadTimeout(),
                        ThreadPoolConfig.defaultCorePoolSize(),
                        ThreadPoolConfig.defaultMaxPoolSize(),
                        ThreadPoolConfig.defaultTimeout(),
                        ThreadPoolConfig.linkedBlockingQueue(),
                        ThreadPoolConfig.defaultRejectionPolicy()
                ));
        return builder.config();
    }
}
