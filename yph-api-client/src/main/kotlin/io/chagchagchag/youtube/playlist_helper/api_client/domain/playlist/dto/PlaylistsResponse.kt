package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto

import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PageInfo
import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PlaylistItem


data class PlaylistsResponse(
    val kind: String,
    val etag: String,
    val pageInfo: PageInfo, // TODO : 헐 이거 제공해주네... 나중에 커스텀 자료로 변경하기
    val items: List<PlaylistItem>, // TODO : 헐 이거 제공해주네... 나중에 커스텀 자료로 변경하기
)
