package io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model

data class PlaylistItem(
    val contentDetails: PlaylistItemContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: PlaylistItemSnippet,
    val status: PlaylistItemStatus
)
