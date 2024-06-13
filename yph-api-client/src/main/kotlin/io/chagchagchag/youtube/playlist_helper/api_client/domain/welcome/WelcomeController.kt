package io.chagchagchag.youtube.playlist_helper.api_client.domain.welcome

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {
  @GetMapping("/welcome")
  fun welcome(): String{
    return "OK"
  }
}