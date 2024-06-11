package io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.rest

import io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.client.PostClient
import io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.dto.Post
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonPlaceholderController (
    val postClient: PostClient
){
  @GetMapping(value = ["posts/{id}"])
  fun getPostsById(@PathVariable(value = "id") id : Int) : List<Post> = postClient.getPostById(id)
}