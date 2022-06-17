package com.example.mvpexamplewithkotlin.framework.util.thread

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

class ThreadUtil {

    companion object {
        private val executorServie =
            Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
        private val handler = Handler(Looper.getMainLooper())

        fun startThread(runnable: Runnable) {
            executorServie.submit(runnable)
        }

        fun startUIThread(delayMillis: Int, runnable: Runnable) {
            handler.postDelayed(runnable, delayMillis.toLong())
        }
    }

    protected fun finalize() {
        if (!executorServie.isShutdown) {
            executorServie.shutdown()
        }
    }
}