package com.colak.springrestclienttutorial.service.resttemplate;

import com.colak.springrestclienttutorial.dto.QuoteRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService restTemplateService;

    @LocalServerPort
    int randomPort;

    @Test
    void testGetString() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquote";
        String page = restTemplateService.getString(url);
        assertThat(page).isEqualTo("quote");
    }

    @Test
    void testGetStringList() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquotelist";
        List<String> result = restTemplateService.getStringList(url);
        List<String> expected = List.of("quote1", "quote1");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testPostForEntity() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("new quote");
        String result = restTemplateService.postForEntity(url, quoteRequestDto);
        String expected = "Added new quote " + quoteRequestDto.quote();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testPostObject() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/addquote";
        QuoteRequestDto quoteRequestDto = new QuoteRequestDto("new quote");
        String result = restTemplateService.postForObject(url, quoteRequestDto);
        String expected = "Added new quote " + quoteRequestDto.quote();
        Assertions.assertEquals(expected, result);
    }
}
