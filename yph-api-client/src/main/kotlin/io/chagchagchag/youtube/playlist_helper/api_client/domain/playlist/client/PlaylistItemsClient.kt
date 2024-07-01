package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.client

import com.google.api.services.youtube.model.PlaylistItemListResponse
import feign.Headers
import feign.Param
import feign.RequestLine
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistItemsDeleteRequest
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistItemsInsertRequest
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.request.PlaylistItemsUpdateRequest
import io.chagchagchag.youtube.playlist_helper.api_client.global.youtube.model.PlaylistItem
import reactor.core.publisher.Mono

interface PlaylistItemsClient {

  /** (list)
   *  필수
   *    part : id, snippet, contentDetails, ...
   *  filter
   *    id : 하나 이상의 고유한 재생목록 항목 ID 목록
   *  optional
   *    maxResults : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   */
  @Headers("Content-Type: application/json")
  @RequestLine("GET /youtube/v3/playlistItems?part={part}&id={id}&maxResults={maxResults}")
  fun requestPlaylistItemsByIds(
      @Param part: String,
      @Param id: String,
      @Param maxResults: Int = 5,
  ): Mono<PlaylistItemListResponse>

  /** (list)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * filter
   *    playlistId : 재생목록 항목을 검색하려는 재생목록의 고유 ID
   * optional
   *    maxResults : 결과 집합으로 반환해야 하는 최대 항목 수 (0~50, 기본값: 5)
   */
  @Headers("Content-Type: application/json")
  @RequestLine("GET /youtube/v3/playlistItems?part={part}&playlistId={playlistId}")
  fun requestPlaylistItemsByPlaylistId(
      @Param part: String,
      @Param playlistId: String,
      @Param maxResults: Int = 5,
  ): Mono<PlaylistItemListResponse>

  /** (insert)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * optional
   *    onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
   */
  @Headers("Content-Type: application/json")
  @RequestLine("POST /youtube/v3/playlistItems")
  fun requestPlaylistItemsInsert(
      insertRequest: PlaylistItemsInsertRequest
  ): Mono<PlaylistItem>

  /** (update)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * optional
   *    onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
   */
  @Headers("Content-Type: application/json")
  @RequestLine("PUT /youtube/v3/playlistItems")
  fun requestPlaylistItemsUpdate(
      updateRequest: PlaylistItemsUpdateRequest
  ): Mono<PlaylistItem>

  /** (delete)
   * 필수
   *    part : id, snippet, contentDetails, ...
   * optional
   *    onBehalfOfContentOwner : 콘텐츠 소유자를 대신하는 YouTube CMS 사용자를 식별하는 매개변수
   */
  @Headers("Content-Type: application/json")
  @RequestLine("DELETE /youtube/v3/playlistItems")
  fun requestPlaylistItemsDelete(
      deleteRequest: PlaylistItemsDeleteRequest
  ): Mono<PlaylistItem>

}