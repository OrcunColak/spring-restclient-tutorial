package com.colak.springrestclienttutorial.service.get;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class GetService {

    private final RestClient followRedirectRestClient;

    public String downloadPage(String url) {
        return RestClient.create()
                .get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }

    public String downloadPageWithRedirect(String url) {
        return followRedirectRestClient
                .get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }
}
