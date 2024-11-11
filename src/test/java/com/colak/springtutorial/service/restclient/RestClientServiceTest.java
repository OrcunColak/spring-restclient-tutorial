package com.colak.springtutorial.service.restclient;

import com.colak.springtutorial.dto.QuoteRequestDto;
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
    void testGetString() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        String page = restClientService.getString(url);
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void testPostForObject() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("my-quote");
        String page = restClientService.postForObject(url, quoteRequestDto);
        assertThat(page).isEqualTo("Added new quote my-quote");
    }

    @Test
    void testGetStringWithRedirect() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/redirect";
        String page = restClientService.getStringWithRedirect(url);
        assertThat(page).isEqualTo("new quote");
    }
}
