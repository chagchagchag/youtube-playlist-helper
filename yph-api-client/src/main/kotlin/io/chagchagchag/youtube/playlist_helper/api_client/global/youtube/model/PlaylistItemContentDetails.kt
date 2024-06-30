package io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model

import com.google.api.client.util.DateTime

data class PlaylistItemContentDetails (
    val endAt: String,
    val note: String,
    val startAt: String,
    val videoId: String,
    val videoPublishedAt: DateTime
){
}