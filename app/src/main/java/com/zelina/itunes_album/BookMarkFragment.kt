package com.zelina.itunes_album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.zelina.itunes_album.adapter.BookMarkAdapter
import com.zelina.itunes_album.databinding.FragmentBookMarkBinding
import com.zelina.itunes_album.databinding.ListBookmarkBinding
import com.zelina.itunes_album.models.AlbumListModel

/**
 * A simple [Fragment] subclass.
 * Use the [BookMarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookMarkFragment(var albumList:List<AlbumListModel>, val fm:FragmentManager) : Fragment() {
    lateinit var mBinding: FragmentBookMarkBinding
    lateinit var mAdapter:BookMarkAdapter
    var mList= mutableListOf<AlbumListModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding= FragmentBookMarkBinding.inflate(layoutInflater)
        mList.clear()
        //just add the albums that are bookmarked by the user
        for(album in albumList){
            if (album.isBookmarked)
                mList.add(album)
        }
        mAdapter= BookMarkAdapter(mList)
        mBinding.bookmarkList.apply{
            adapter=mAdapter
        }

        //when the user click back, pop the current fragment
        mBinding.toolbar.setNavigationOnClickListener {
            fm.popBackStackImmediate()
        }
        return mBinding.root
    }

}