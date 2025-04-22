# Builder

Use

```
RestClient weatherClient = RestClient.builder()
  .baseUrl("https://api.openweathermap.org")
  .defaultHeader("request-id", "req1")
  .build();
```

Retry logic
```java
RestClient.builder()
    .requestFactory(factory -> factory
        .filter(ExchangeFilterFunctions.retry(3)))
    .build();
```

# Default RestClient

Use

```
RestClient defaultClient = RestClient.create();
```
or
```java
RestClient restClient = RestClient.create();
String response = restClient.get()
    .uri("https://api.example.com/data")
    .retrieve()
    .body(String.class);
```
The original idea is from  
https://medium.com/@mustafaguc/building-kafka-producer-and-consumer-microservices-with-spring-boot-on-kubernetes-using-github-0bd0af37e538

# Timeout RestClient

The original idea is from  
https://dzone.com/articles/timeout-in-spring-boot-with-restclient-webclient-a
```java
// Handled at the HttpClient level:

HttpClient httpClient = HttpClient.create()
    .responseTimeout(Duration.ofSeconds(5));
ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
RestClient client = RestClient.builder()
    .requestFactory(WebClientAdapter.forClient(WebClient.builder()
        .clientConnector(connector)
        .build()))
    .build();
```

# Proxy Support
```java
// Also part of the HttpClient config:

HttpClient httpClient = HttpClient.create()
    .proxy(proxy -> proxy
        .type(ProxyProvider.Proxy.HTTP)
        .host("localhost")
        .port(8888));
```
# Redirecting RestClient

The original idea is from  
https://medium.com/@mustafaguc/how-to-create-a-web-page-scraper-using-java-virtual-threads-in-spring-boot-microservice-6662e56316ca

# SSL RestClient

I did not implement it but the original idea is from  
https://medium.com/@rakeshgr316/securing-restful-connections-enabling-and-disabling-ssl-with-spring-boot-bdf3e6a26711

# ResponseBodyAdvice

The original idea is from
https://medium.com/@dixitsatish34/customize-response-using-responsebodyadvice-in-spring-boot-acee5ad2c43a
