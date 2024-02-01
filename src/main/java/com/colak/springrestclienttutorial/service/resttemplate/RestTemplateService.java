package com.colak.springrestclienttutorial.service.resttemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateService {

    public String getString(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);
    }
    /**
     * Example that demonstrates how to get using exchange()
     */
    public List<String> getStringList(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }

    /**
     * Example that demonstrates how to post using postForEntity()
     */
    public String postForEntity(String url, Object object) {
        RestTemplate restTemplate = new RestTemplate();
        // The result is of String type
        ResponseEntity<String> response = restTemplate.postForEntity(url, object, String.class);
        return response.getBody();
    }

    /**
     * Example that demonstrates how to post using postForObject()
     */
    public <T> String postForObject(String url, T object) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<T> request = new HttpEntity<>(object);
        // The result is of String type
        return restTemplate.postForObject(url, request, String.class);
    }
}
