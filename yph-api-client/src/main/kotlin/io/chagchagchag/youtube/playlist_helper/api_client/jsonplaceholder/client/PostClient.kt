package io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.client

import io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.dto.Post
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "postClient", url = "\${json-placeholder.url}")
interface PostClient {
  @RequestMapping(method = [RequestMethod.GET], value = ["/posts/{id}"], produces = ["application/json"])
  fun getPostById(@PathVariable(value = "id") id: Int): List<Post>
}