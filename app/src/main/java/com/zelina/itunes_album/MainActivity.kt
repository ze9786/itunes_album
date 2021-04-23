package com.zelina.itunes_album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.ListView
import com.zelina.itunes_album.adapter.AlbumAdapter
import com.zelina.itunes_album.models.AlbumListModel
import com.zelina.itunes_album.network.AlbumConverter
import com.zelina.itunes_album.viewModels.AlbumViewModel

class MainActivity : AppCompatActivity() {
    var list= mutableListOf<AlbumListModel>()
    private val mViewModel:AlbumViewModel = AlbumViewModel()
    lateinit var mAdapter: AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var respond=AlbumConverter().convertToAlbum()
        list.clear()
        if (respond != null) {
            for(i in 0 until respond.resultCount!!){
                list.add(AlbumListModel(artistName = respond.results[i].artistName, collectionName = respond.results[i].collectionName, collectionCensoredName = respond.results[i].collectionCensoredName, false))
            }
        }

//        list.add(AlbumListModel("asdf", "hihi", "abc", false))
//        list.add(AlbumListModel("asdf", "hihi", "abc", false))
//        list.add(AlbumListModel("asdf", "hihi", "abc",false))
//        list.add(AlbumListModel("asdf", "hihi", "abc",false))
        mAdapter= AlbumAdapter(list)
        val albumListView=findViewById<ListView>(R.id.album_list)
        albumListView.apply {
            adapter=mAdapter
        }
    }


}