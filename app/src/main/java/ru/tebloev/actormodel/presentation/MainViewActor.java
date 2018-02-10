package ru.tebloev.actormodel.presentation;

import android.content.Context;
import android.widget.Toast;

import akka.actor.AbstractActor;

/**
 * Актор для взаимодействия с ui {@link MainActivity}
 *
 * @author Tebloev Vladimir
 */

public class MainViewActor extends AbstractActor {

    private final Context mContext;

    /**
     * Конструктор по умолчанию
     *
     * @param mContext контекст активити
     */
    public MainViewActor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(String.class, message -> {
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
        }).build();
    }
}
