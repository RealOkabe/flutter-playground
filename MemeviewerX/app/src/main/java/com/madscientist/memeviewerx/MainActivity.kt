package com.madscientist.memeviewerx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.madscientist.memeviewerx.util.Constants
import okhttp3.*
import java.io.IOException
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            fetchMemes()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun fetchMemes() {
        val request = Request.Builder().url(Constants.MEME_URL).build()
        val call = OkHttpClient().newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()
                Log.d("*****", body!!.string())
            }

        })
    }

}