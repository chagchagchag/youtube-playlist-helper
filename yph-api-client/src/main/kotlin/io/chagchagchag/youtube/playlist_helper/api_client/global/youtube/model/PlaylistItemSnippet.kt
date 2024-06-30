package io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model

import com.google.api.services.youtube.model.ResourceId

data class PlaylistItemSnippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val playlistId: String,
    val position: Long,
    val publishedAt: String,
    val resourceId: ResourceId,
    val thumbnails: ThumbnailDetails
)
