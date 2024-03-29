package com.colak.springrestclienttutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
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
