package com.zelina.itunes_album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            var albumFragment=AlbumFragment()
            supportFragmentManager
                // 3
                .beginTransaction()
                // 4
                .replace(R.id.fragment_container_view, albumFragment, "albumList")
                // 5
                .commit()
        }
    }

}