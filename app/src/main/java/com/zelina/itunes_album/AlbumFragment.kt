package com.zelina.itunes_album

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.zelina.itunes_album.adapter.AlbumAdapter
import com.zelina.itunes_album.databinding.FragmentAlbumBinding
import com.zelina.itunes_album.models.AlbumListModel
import com.zelina.itunes_album.network.AlbumConverter


/**
 * A simple [Fragment] subclass.
 * Use the [AlbumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumFragment : Fragment() {
    var list= mutableListOf<AlbumListModel>()
    lateinit var mAdapter: AlbumAdapter
    lateinit var mBinding: FragmentAlbumBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding= FragmentAlbumBinding.inflate(layoutInflater)
        var respond= AlbumConverter().convertToAlbum()
        list.clear()
        if (respond != null) {
            for(i in 0 until respond.resultCount!!){
                list.add(
                    AlbumListModel(
                        artistName = respond.results[i].artistName,
                        collectionName = respond.results[i].collectionName,
                        collectionPrice = respond.results[i].collectionPrice,
                        currency = respond.results[i].currency,
                        false
                    )
                )
            }
        }
        mAdapter= AlbumAdapter(list)
        mBinding.albumList.apply {
            adapter=mAdapter
        }



        mBinding.bookmarkIcon.setOnClickListener {
            //TODO: stack when bookmark is clicked
            val fragment2 = BookMarkFragment(list)
            val fragmentManager = childFragmentManager
            val id=this.id
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(id, fragment2, "bookmarkList").commit()

        }
        return mBinding.root
    }
}