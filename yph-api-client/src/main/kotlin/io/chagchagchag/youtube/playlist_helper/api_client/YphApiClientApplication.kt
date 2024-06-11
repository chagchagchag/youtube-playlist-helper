package io.chagchagchag.youtube.playlist_helper.api_client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class PlaylistHelperApplication

fun main(args: Array<String>) {
	runApplication<PlaylistHelperApplication>(*args)
}
