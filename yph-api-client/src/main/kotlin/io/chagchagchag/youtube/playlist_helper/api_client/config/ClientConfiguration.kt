package io.chagchagchag.youtube.playlist_helper.api_client.config

import feign.Logger
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import feign.okhttp.OkHttpClient
import org.apache.http.entity.ContentType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfiguration {
  @Bean
  fun client(): OkHttpClient = OkHttpClient()

  @Bean
  fun errorDecoder(): ErrorDecoder = CustomErrorDecoder()

  @Bean
  fun feignLoggerLevel(): Logger.Level = Logger.Level.FULL

  fun requestInterceptor(): RequestInterceptor {
    return RequestInterceptor {
      it.header("Accept", ContentType.APPLICATION_JSON.mimeType)
    }
  }
}