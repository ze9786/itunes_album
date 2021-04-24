package com.zelina.itunes_album

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.zelina.itunes_album.adapter.BookMarkAdapter
import com.zelina.itunes_album.databinding.FragmentBookMarkBinding
import com.zelina.itunes_album.databinding.ListBookmarkBinding
import com.zelina.itunes_album.models.AlbumListModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookMarkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookMarkFragment(var albumList:List<AlbumListModel>) : Fragment() {
    lateinit var mBinding: FragmentBookMarkBinding
    lateinit var mAdapter:BookMarkAdapter
    var mList= mutableListOf<AlbumListModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding= FragmentBookMarkBinding.inflate(layoutInflater)
        mList.clear()
        for(album in albumList){
            if (album.isBookmarked)
                mList.add(album)
        }
        mAdapter= BookMarkAdapter(mList)
        mBinding.bookmarkList.apply{
            adapter=mAdapter
        }

        mBinding.toolbar.setNavigationOnClickListener {
            val fragmentManager = childFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(this)
        }
        return mBinding.root
    }

}