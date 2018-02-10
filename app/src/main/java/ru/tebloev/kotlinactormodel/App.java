package ru.tebloev.kotlinactormodel;

import android.app.Application;

import akka.actor.ActorSystem;

/**
 * Created by Balodya on 10.02.2018.
 */

public class App extends Application {

    private static final String ACTOR_SYSTEM_NAME = "System";

    private static ActorSystem mSystem;

    @Override
    public void onCreate() {
        super.onCreate();
        mSystem = ActorSystem.create(ACTOR_SYSTEM_NAME);
    }

    public static ActorSystem provideActorSystem() {
        return mSystem;
    }
}
