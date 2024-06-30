package io.chagchagchag.draft

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import com.google.api.services.youtube.model.PlaylistListResponse
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource
import java.io.InputStream
import java.io.InputStreamReader

class YoutubeDataApiSampleTest {
  val CLIENT_SECRETS = "client_secret_chagchagchag.dev.json";
  val scopes = listOf("https://www.googleapis.com/auth/youtube.readonly")

  val application_name = "Api Code Sample"
  val jsonFactory : JsonFactory = JacksonFactory.getDefaultInstance();

  fun authorize(httpTransport: NetHttpTransport) : Credential {
    val inputStream: InputStream = ClassPathResource("ignore/client_secret_chagchagchag.dev.json").inputStream
    val clientSecrets: GoogleClientSecrets = GoogleClientSecrets.load(jsonFactory, InputStreamReader(inputStream))

    val flow: GoogleAuthorizationCodeFlow = GoogleAuthorizationCodeFlow
            .Builder(httpTransport, jsonFactory, clientSecrets, scopes)
            .build()

    val credential: Credential = AuthorizationCodeInstalledApp(flow, LocalServerReceiver())
            .authorize(null)
    return credential
  }

  fun getService(): YouTube {
    val httpTransport: NetHttpTransport = GoogleNetHttpTransport.newTrustedTransport()
    val credential: Credential = authorize(httpTransport)
    return YouTube.Builder(httpTransport, jsonFactory, credential)
            .setApplicationName(application_name)
            .build()
  }


  @Test
  fun playlist_sample_test(){
    val youtubeService : YouTube = getService()
    val request : YouTube.Playlists.List = youtubeService.playlists().list("snippet,contentDetails")
    val response: PlaylistListResponse = request.setChannelId("UC_x5XG1OV2P6uZZ5FSM9Ttw")
            .setMaxResults(25L)
            .execute()

    println("response >>> ${response}")
  }

}