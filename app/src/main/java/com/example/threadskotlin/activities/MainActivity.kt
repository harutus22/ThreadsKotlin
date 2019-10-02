package com.example.threadskotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import com.example.threadskotlin.R
import com.example.threadskotlin.runnable.MyRunnable
import com.example.threadskotlin.threads.MyThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var runnable: MyRunnable
    private lateinit var handler: Handler
    private lateinit var thread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = object: Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val mes = msg.what.toString()
                numberCount.text = "$mes%"
            }
        }
    }

    fun startThread(view: View){
        thread = MyThread(handler)
        runnable = MyRunnable(handler)
        thread.start()
//        val otherThread = Thread(runnable)
//        otherThread.start()
    }

    fun stopThread(view: View){
//        runnable.isRunning = false
        thread.isRunning = false
    }
}
