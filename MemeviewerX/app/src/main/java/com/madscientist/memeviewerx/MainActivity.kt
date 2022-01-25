package com.madscientist.memeviewerx

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.madscientist.memeviewerx.util.Constants
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    var memeView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        memeView = findViewById(R.id.memeView)
        try {
            fetchMemes()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun fetchMemes() {
        val request = Request.Builder().url(Constants.MEME_URL).build()
        val call = OkHttpClient().newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body()
                val jsonObject = JSONObject(body!!.string()).getJSONObject("data")
                val jsonArray = jsonObject.getJSONArray("memes")
                val memeList = ArrayList<Meme>()
                val memeUrls = ArrayList<String>()
                for(meme in 0 until jsonArray.length()) {
                    val memeObject = jsonArray.getJSONObject(meme)
                    memeList.add(Meme(memeObject.get("name") as String, null))
                    memeUrls.add(memeObject.get("url") as String)
                }
                for(i in 0 until memeUrls.size) {
                    val imageStream = java.net.URL(memeUrls[i]).openStream()
                    memeList[i].memeImage = BitmapFactory.decodeStream(imageStream)
                }
                runOnUiThread {
                    memeView!!.adapter = MemeAdapter(memeList)
                    memeView!!.layoutManager = LinearLayoutManager(applicationContext)
                }
            }

        })
    }

}