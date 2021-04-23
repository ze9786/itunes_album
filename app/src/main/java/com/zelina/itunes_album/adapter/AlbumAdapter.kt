package com.zelina.itunes_album.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import com.zelina.itunes_album.databinding.ListAlbumBinding
import com.zelina.itunes_album.models.AlbumListModel

class AlbumAdapter(private val items:List<AlbumListModel>) :BaseAdapter(){
    lateinit var mBinding: ListAlbumBinding
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        val layoutInflater=LayoutInflater.from(parent.context)
        var albumListModel=getItem(position) as AlbumListModel
        if(view==null){
            mBinding= ListAlbumBinding.inflate(layoutInflater)
            view=mBinding.root
            view.tag=mBinding
        }else
            mBinding=view.tag as ListAlbumBinding

        mBinding.albumListModel=albumListModel

        return view
    }
}