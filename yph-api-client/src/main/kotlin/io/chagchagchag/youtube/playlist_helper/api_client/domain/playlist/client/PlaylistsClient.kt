package io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.client

import feign.Headers
import feign.Param
import feign.RequestLine
import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.dto.PlaylistsResponse
import reactor.core.publisher.Mono

interface PlaylistsClient {
  @RequestLine("GET /youtube/v3/playlists?part={part}&channelId={channelId}&maxResults={maxResults}&key={key}")
  @Headers(value = ["Content-Type: application/json"])
  fun requestPlaylists(
      @Param part: String,
      @Param channelId: String,
      @Param maxResults: Int,
      @Param key: String
  ): Mono<PlaylistsResponse>
}