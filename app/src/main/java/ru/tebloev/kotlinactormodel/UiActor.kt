package ru.tebloev.kotlinactormodel

import akka.actor.AbstractActor
import akka.actor.UntypedAbstractActor
import akka.japi.pf.FI
import akka.japi.pf.ReceiveBuilder
import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * @author Tebloev Vladimir
 */
class UiActor : UntypedAbstractActor {

    private var mContext : Context
    constructor(context: Context) {
        mContext = context
    }

    override fun onReceive(message: Any?) = when (message) {
        is String -> {
            Log.d("Actor", message);
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
        } else -> {
            Log.d("Actor", "Unknown");
            Toast.makeText(mContext, "Unknown", Toast.LENGTH_LONG).show()
        }
    }
}