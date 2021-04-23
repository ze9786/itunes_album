package com.zelina.itunes_album.models

import android.view.View

data class AlbumListModel(
    var artistName: String,
    var collectionName: String,
    var collectionPrice: Double,
    val currency: String,
    var isBookmarked: Boolean,
)