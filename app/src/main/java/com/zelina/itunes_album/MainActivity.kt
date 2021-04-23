package com.zelina.itunes_album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView
import com.zelina.itunes_album.adapter.AlbumAdapter
import com.zelina.itunes_album.models.AlbumListModel
import com.zelina.itunes_album.viewModels.AlbumViewModel

class MainActivity : AppCompatActivity() {
    var list= mutableListOf<AlbumListModel>()
    private val mViewModel:AlbumViewModel = AlbumViewModel()
    lateinit var mAdapter: AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.clear()
        list.add(AlbumListModel("asdf", "hihi", "abc"))
        list.add(AlbumListModel("asdf", "hihi", "abc"))
        list.add(AlbumListModel("asdf", "hihi", "abc"))
        list.add(AlbumListModel("asdf", "hihi", "abc"))
        mAdapter= AlbumAdapter(list)
        val albumListView=findViewById<ListView>(R.id.album_list)
        albumListView.apply {
            adapter=mAdapter
        }
    }


}