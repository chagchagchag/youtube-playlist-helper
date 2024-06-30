package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request

/**
 * part : id, snippet, contentDetails, ...
 * onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
 */
data class PlaylistItemsUpdateRequest(
    val part: String,
    val onBehalfOfContentOwner: String?,
)
