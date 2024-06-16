package io.chagchagchag.youtube.playlist_helper.api_client.domain.auth.rest

import io.chagchagchag.youtube.playlist_helper.api_client.domain.auth.client.AuthClient
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
class AuthController (
    val authClient: AuthClient, // TODO : 구현 완료되면 ApplicationService 로 분리
    @Value("\${spring.security.oauth2.client.registration.google.client-id}") val clientId: String,
){

  val logger : Logger = LoggerFactory.getLogger(this.javaClass)

  @GetMapping("/welcome")
  fun welcome(
          @RequestParam("code") code: String,
          @RequestParam("scope") scope: String,
  ): String{
    return "OK"
  }

  @GetMapping("/auth")
  fun getAuth(
      @RequestHeader("token") token : Optional<String>
  ): Mono<String> {
    return Mono.empty()
  }
}