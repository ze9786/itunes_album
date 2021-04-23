package com.zelina.itunes_album.network

import android.os.Build
import android.os.StrictMode
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class AlbumConverter {
    var client = OkHttpClient()

    @Throws(IOException::class)
    fun run(url: String?): String? {
        val request: Request = Request.Builder()
            .url(url!!)
            .build()
        if (Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }
        client.newCall(request).execute().use { response -> return response.body?.string() }
    }


    fun convertToAlbum(): GetAlbumModelRespond? {
        var response=run("https://itunes.apple.com/search?term=jack+johnson&entity=album")
        val adapter: TypeAdapter<GetAlbumModelRespond>? = Gson().getAdapter(
            GetAlbumModelRespond::class.java)
        var tempRespond= adapter?.fromJson(response)
        return tempRespond
    }
}