package com.example.threadskotlin.runnable

import android.os.Handler
import android.util.Log


class MyRunnable(private val handler: Handler): Runnable {
    var isRunning: Boolean = false

    override fun run() {
        isRunning = true
        for (k in 0..100 step 10){
            if(!isRunning) break
            Log.d("TAG", k.toString())
            Thread.sleep(1000)
            handler.sendEmptyMessageDelayed(k, 0)
        }
    }
}