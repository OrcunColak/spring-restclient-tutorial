package com.colak.springrestclienttutorial.service.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestClientServiceTest {

    @Autowired
    private RestClientService restClientService;

    @LocalServerPort
    int randomPort;

    @Test
    void downloadPage() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        String page = restClientService.downloadPage(url);
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void downloadPageWithRedirect() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/redirect";
        String page = restClientService.downloadPageWithRedirect(url);
        assertThat(page).isEqualTo("new quote");
    }

}
