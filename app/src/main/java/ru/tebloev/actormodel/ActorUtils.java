package ru.tebloev.actormodel;

import akka.actor.ActorRef;
import akka.actor.Props;

/**
 * Утилитный класс для работы с акторами
 * @author Tebloev Vladimir
 */

public class ActorUtils {

    public static final String MAIN_THREAD_DISPATCHER = "main-thread-dispatcher";

    /**
     * Создание {@link ActorRef}, который будет привязан к main thread. Нужен для того, чтобы акторы могли обращаться к ui
     * @param name имя создаваемого актора
     * @param clazz класс актора
     * @param args аргументы констуктора актора
     * @return {@link ActorRef}
     */
    public static ActorRef getActorRefWithUiDispatcher(String name, Class clazz, Object... args) {
        return App.provideActorSystem().actorOf(Props.create(clazz, args).withDispatcher(MAIN_THREAD_DISPATCHER), name);
    }

    /**
     * Создание {@link ActorRef} со стандартным диспетчером
     * @param name имя создаваемого актора
     * @param clazz класс актора
     * @param args аргументы констуктора актора
     * @return {@link ActorRef}
     */
    public static ActorRef getActorRef(String name, Class clazz, Object... args) {
        return App.provideActorSystem().actorOf(Props.create(clazz, args), name);
    }
}
