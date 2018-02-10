package ru.tebloev.actormodel.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import akka.actor.ActorRef;
import ru.tebloev.actormodel.ActorUtils;
import ru.tebloev.actormodel.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActorRef myActor = ActorUtils.getActorRefWithUiDispatcher("MainActor", MainViewActor.class, this);
        myActor.tell("yes, yes, yes", ActorRef.noSender());
    }
}
