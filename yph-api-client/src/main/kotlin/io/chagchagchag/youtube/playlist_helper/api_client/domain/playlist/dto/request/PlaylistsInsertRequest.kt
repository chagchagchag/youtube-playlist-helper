package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request

/**
 * part : id, snippet, contentDetails, ...
 * onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
 * onBehalfOfContentOwnerChannel :
 * - 승인된 요청에서만 사용가능
 * - 동영상을 추가할 채널의 YouTube 채널 ID
 * - onBehalfOfContentOwner 파라미터의 값을 지정할 때 필요하며 onBehalfOfContentOwner 함께만 사용가능
 * - onBehalfOfContentOwnerChannel 이 지정하는 채널은 onBehalfOfContentOwner (컨텐츠소유자)와 연결되어 있어야 합니다
 */
data class PlaylistsInsertRequest(
    val part: String,
    val onBehalfOfContentOwner: String?,
    val onBehalfOfContentOwnerChannel: String?,
)
