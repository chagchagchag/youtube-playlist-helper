package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.client

import feign.Headers
import feign.Param
import feign.RequestLine
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.PlaylistsResponse
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistsDeleteRequest
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistsInsertRequest
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistsUpdateRequest
import reactor.core.publisher.Mono

interface PlaylistsClient {

  /** (list)
   * 인증 파라미터
   *    key : API KEY
   * 필수
   *    part : id, snippet, contentDetails, ...
   * filter
   *    channelId : API 에 지정한 채널의 재생목록만 반환
   * optional
   *    maxResults : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("GET /youtube/v3/playlists?part={part}&channelId={channelId}&maxResults={maxResults}&key={key}")
  fun requestPlaylistsByChannelId(
      @Param part: String,
      @Param channelId: String,
      @Param maxResults: Int = 5,
      @Param key: String,
  ): Mono<PlaylistsResponse>

  /** (list)
   *  인증 파라미터
   *    key : API KEY
   *  필수
   *    part : id, snippet, contentDetails, ...
   *  filter
   *    id : 하나 이상의 고유한 재생목록 항목 ID 목록
   *  optional
   *    maxResults : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("GET /youtube/v3/playlistItems?part={part}&id={id}&maxResults={maxResults}")
  fun requestPlaylistItemsByPlaylistId(
          @Param part: String,
          @Param id: String,
          @Param maxResults: Int = 5,
          @Param key: String,
  ): Mono<PlaylistsResponse>

  /** (list)
   *  필수
   *    part : id, snippet, contentDetails, ...
   *  filter
   *    mine : 인증을 받은 (승인) 요청에 대해 그 사용자가 소유한 재생목록만을 return
   *  optional
   *    maxResults : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("GET /youtube/v3/playlists?part={part}&mine={mine}&maxResults={maxResults}&key={key}")
  fun requestPlaylistsByMine(
      @Param part: String,
      @Param mine: Boolean = true,
      @Param maxResults: Int,
  ): Mono<PlaylistsResponse>

  /** (insert)
   *  필수
   *    part : id, snippet, contentDetails, ...
   *  optional
   *    onBehalfOfContentOwner : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   *    onBehalfOfContentOwnerChannel :
   *    - 승인된 요청에서만 사용가능
   *    - 동영상을 추가할 채널의 YouTube 채널 ID
   *    - onBehalfOfContentOwner 파라미터의 값을 지정할 때 필요하며 onBehalfOfContentOwner 함께만 사용가능
   *    onBehalfOfContentOwnerChannel 이 지정하는 채널은 onBehalfOfContentOwner (컨텐츠소유자)와 연결되어 있어야 합니다
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("POST /youtube/v3/playlists")
  fun requestPlaylistsInsert(
      insertRequest: PlaylistsInsertRequest
  )

  /** (update)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * optional
   *    onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("PUT /youtube/v3/playlists")
  fun requestPlaylistsUpdate(
      updateRequest: PlaylistsUpdateRequest
  )

  /** (delete)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * optional
   *    onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
   */
  @Headers(value = ["Content-Type: application/json"])
  @RequestLine("DELETE /youtube/v3/playlists")
  fun requestPlaylistsDelete(
      deleteRequest: PlaylistsDeleteRequest
  )

}