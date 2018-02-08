package ru.tebloev.kotlinactormodel

import android.os.Looper
import java.util.concurrent.ThreadFactory

/**
 * @author Tebloev Vladimir
 */
class MainThreadFactory : ThreadFactory {
    override fun newThread(r: Runnable?): Thread {
        return Looper.getMainLooper().thread
    }

}