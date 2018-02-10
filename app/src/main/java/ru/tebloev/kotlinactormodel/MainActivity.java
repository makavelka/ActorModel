package ru.tebloev.kotlinactormodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActorRef myActor = App.provideActorSystem().actorOf(Props.create(UiActor.class, this).withDispatcher("main-thread-dispatcher"), "actor");
        myActor.tell("yes, yes, yes", ActorRef.noSender());
    }
}
