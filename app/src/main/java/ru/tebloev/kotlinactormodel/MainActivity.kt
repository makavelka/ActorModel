package ru.tebloev.kotlinactormodel

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val system = ActorSystem.create("MySystem")
        val myActor = system.actorOf(Props.create(UiActor::class.java, this),"myActor")
        myActor.tell("test", ActorRef.noSender())
    }
}
