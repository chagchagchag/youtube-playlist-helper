
## 1. Playlist API Client 작성
무엇을
- Playlist:list, Insert API, Update API, Delete API 에 대한 FeignClient 를 작성한다.

어떻게
- FeignClient 작성시 필요한 API 형식을 맞춰야 한다.
- List API, Insert API, Update API, Delete API 에 대한 http 요청을 작성해둔다.

- [youtube playlist API 명세 (1) - list](https://velog.io/@qpwoeiworker/youtube-playlist-API-%EB%AA%85%EC%84%B8-1-list)

<br/>



## 2. 테스트 계정, 테스트 Token 준비 

무엇을 

- Access Token 을 얻어오기 까지의 과정을 테스트 계정 또는 개발 서버 버전에서 수행할 수 있는 방법을 만들어낸다.

어떻게

- Swagger 에서 Access Token 을 얻어오는 과정을 만들 수 있도록 세팅한다.
- 또는 Postman 을 활용한다.
- 또는 Selenium 을 활용한다.
- 테스트 계정을 생성한다.
- 브라우저에서 이동해서 내가 원하는 계정을 선택했을 때 어떤 HTTP 요청을 보내는지 캡처해두고 그 요청을 Swagger, 또는 Postman 등에 구현해둔다.

