package io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder

import io.chagchagchag.youtube.playlist_helper.api_client.jsonplaceholder.dto.Post
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
interface JsonPlaceHolderClient {
  @RequestMapping(method = [RequestMethod.GET], value = ["/posts"])
  fun getPosts() : List<Post> ;
}