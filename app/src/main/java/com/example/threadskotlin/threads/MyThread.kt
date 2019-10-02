package com.example.threadskotlin.threads

import android.os.Handler
import android.util.Log

class MyThread(private val handler: Handler): Thread(){
    var isRunning = false

    override fun run() {
        super.run()
        isRunning = true
        for (n in 0..100 step 10){
            if(!isRunning){
                break
            }
            Log.d("TAG", n.toString())
            handler.sendEmptyMessage(n)
            sleep(1000)
        }
    }
}