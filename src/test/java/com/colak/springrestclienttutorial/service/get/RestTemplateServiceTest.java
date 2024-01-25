package com.colak.springrestclienttutorial.service.get;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService restTemplateService;

    @LocalServerPort
    int randomPort;

    @Test
    void testDownloadList() {
        String url = "http://localhost:" + randomPort + "/api/v1/quote/getquotelist";
        List<String> result = restTemplateService.downloadList(url);
        List<String> expected = List.of("quote1", "quote1");
        Assertions.assertEquals(expected, result);
    }
}
