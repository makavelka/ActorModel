package ru.tebloev.actormodel;

import android.app.Application;

import akka.actor.ActorSystem;

/**
 * @author Tebloev Vladimir
 */

public class App extends Application {

    private static final String ACTOR_SYSTEM_NAME = "System";

    private static ActorSystem mSystem;

    @Override
    public void onCreate() {
        super.onCreate();
        mSystem = ActorSystem.create(ACTOR_SYSTEM_NAME);
    }

    /**
     * Предоставление системы акторов, которая инициализируется вместе с Application
     * @return система акторов
     */
    public static ActorSystem provideActorSystem() {
        return mSystem;
    }
}
