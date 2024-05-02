package com.colak.springrestclienttutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.util.List;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient followRedirectRestClient() {
        SimpleClientHttpRequestFactory requestFactory = simpleClientHttpRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<ClientHttpRequestInterceptor> interceptorList = List.of(RestTemplateConfig.interceptor());
        restTemplate.setInterceptors(interceptorList);
        return RestClient.create(restTemplate);
    }

    @Bean
    public RestClient timeoutRestClient() {
        var timeout = 5_000;
        //  ClientHttpRequestFactory that uses Apache HttpComponents HttpClient
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(timeout);
        factory.setConnectionRequestTimeout(timeout);

        return RestClient
                .builder()
                .requestFactory(factory)
                .build();
    }

    /**
     * Create a {@link SimpleClientHttpRequestFactory} that follows redirects.
     */
    private static SimpleClientHttpRequestFactory simpleClientHttpRequestFactory() {
        // ClientHttpRequestFactory that uses standard JDK facilities.
        return new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection, String httpMethod) {
                connection.setInstanceFollowRedirects(true);
            }
        };
    }
}
