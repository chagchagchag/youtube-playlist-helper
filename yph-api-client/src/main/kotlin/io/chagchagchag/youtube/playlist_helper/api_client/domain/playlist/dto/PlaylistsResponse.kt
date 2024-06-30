package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto

import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PageInfo
import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PlaylistItem


data class PlaylistsResponse(
    val kind: String,
    val etag: String,
    val pageInfo: PageInfo,
    val items: List<PlaylistItem>,
)
