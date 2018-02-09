package ru.tebloev.kotlinactormodel

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.ExecutorService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val configurator = CustomExecutorServiceConfigurator(null, null)
        val executorServiceFactory = configurator.createExecutorServiceFactory("id", MainThreadFactory())
        val executorService = executorServiceFactory.createExecutorService()
        val system = ActorSystem.create("MySystem")
        val myActor = system.actorOf(Props.create(UiActor::class.java, this),"actor")
        myActor.tell("test", ActorRef.noSender())

    }
}
