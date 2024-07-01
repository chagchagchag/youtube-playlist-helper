package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.response

import com.google.api.services.youtube.model.PlaylistItem
import com.google.api.services.youtube.model.TokenPagination
import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PageInfo

data class PlaylistItemListResponse(
        val etag: String?,
        val eventId: String?,
        val items: List<PlaylistItem>,
        val kind: String?,
        val nextPageToken: String?,
        val pageInfo: PageInfo,
        val prevPageToken: String,
        val tokenPagination: TokenPagination,
        val visitorId: String,
)
