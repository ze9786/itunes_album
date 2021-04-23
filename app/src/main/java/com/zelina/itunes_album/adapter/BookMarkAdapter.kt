package com.zelina.itunes_album.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.google.android.material.snackbar.Snackbar
import com.zelina.itunes_album.R
import com.zelina.itunes_album.databinding.ListBookmarkBinding
import com.zelina.itunes_album.models.AlbumListModel


class BookMarkAdapter(private val items: List<AlbumListModel>) :BaseAdapter(){
    lateinit var mBinding: ListBookmarkBinding

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=convertView
        val layoutInflater=LayoutInflater.from(parent.context)
        var albumListModel = getItem(position) as AlbumListModel
        if(view==null){
            mBinding= ListBookmarkBinding.inflate(layoutInflater)
            view=mBinding.root
            view.tag=mBinding
        }else
            mBinding=view.tag as ListBookmarkBinding

        mBinding.albumListModel=albumListModel
        mBinding.artistName.text="Artist Name: "+items[position].artistName
        mBinding.collectionName.text="Collection Name: "+items[position].collectionName
        mBinding.collectionCensoredName.text="Price: "+items[position].currency+items[position].collectionPrice.toString()


        return view
    }
}