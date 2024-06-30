package io.chagchagchag.youtube.playlist_helper.api_client.playlist

import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.client.PlaylistsClient
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import java.time.Duration

@ActiveProfiles(value = ["local"])
@SpringBootTest
class PlaylistsFeignClientTest {
  @Autowired
  lateinit var playlistsClient: PlaylistsClient

  @Test
  fun test_playlists_api_by_channelId_를_정상적으로_호출하는지_검증(){
    val result = playlistsClient.requestPlaylistsByChannelId(
        part = "snippet, contentDetails",
        channelId = "UC_x5XG1OV2P6uZZ5FSM9Ttw",
        maxResults = 25,
        key = "AIzaSyAeB7eC6dPca1FbfYnepnB9b3fj-ALyS8A"
    )

    val block = result.block(Duration.ofMillis(3000))

    println(block)
  }

  @Test
  fun test_playlists_api_by_mine_을_정상적으로_호출하는지_검증(){
    val result = playlistsClient.requestPlaylistsByMine(
        part = "snippet, contentDetails",
        mine = true,
        maxResults = 25,
    )

    val block = result.block(Duration.ofMillis(3000))

    println(block)
  }


}