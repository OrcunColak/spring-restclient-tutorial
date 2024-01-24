package com.colak.springrestclienttutorial.service.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetServiceTest {

    @Autowired
    private GetService getService;

    @LocalServerPort
    int randomPort;

    @Test
    void downloadPage() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        String page = getService.downloadPage(url);
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void downloadPageWithRedirect() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/redirect";
        String page = getService.downloadPageWithRedirect(url);
        assertThat(page).isEqualTo("new quote");
    }

}
