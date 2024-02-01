package com.colak.springrestclienttutorial.service.restclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class RestClientService {

    private final RestClient followRedirectRestClient;

    public String getString(String url) {
        return RestClient.create()
                .get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }

    public String getStringWithRedirect(String url) {
        return followRedirectRestClient
                .get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }
}
