package com.zelina.itunes_album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            //open the album fragment to show all albums
            var albumFragment=AlbumFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_view, albumFragment, "albumList")
                .commit()
        }
    }

}