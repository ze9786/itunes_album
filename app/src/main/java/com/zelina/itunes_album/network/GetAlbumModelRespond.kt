package com.zelina.itunes_album.network

data class GetAlbumModelRespond(
    val resultCount: Int,
    val results: List<Result>
)