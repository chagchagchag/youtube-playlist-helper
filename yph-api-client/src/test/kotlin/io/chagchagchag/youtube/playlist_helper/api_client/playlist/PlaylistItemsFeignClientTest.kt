package io.chagchagchag.youtube.playlist_helper.api_client.playlist

import io.chagchagchag.youtube.playlist_helper.api_client.domain.playlist.client.PlaylistItemsClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles(value = ["local"])
@SpringBootTest
class PlaylistItemsFeignClientTest {

  @Autowired
  lateinit var playlistItemsClient: PlaylistItemsClient

}