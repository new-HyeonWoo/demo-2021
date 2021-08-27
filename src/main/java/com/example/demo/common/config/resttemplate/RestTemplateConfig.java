package com.example.demo.common.config.resttemplate;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

@Configuration
public class RestTemplateConfig {

    private final int connectTimeout = 15; //연결시간
    private final int readTimeout = 60; //읽는시간
    private final int maxConnTotal = 100; //최대연결갯수
    private final int maxConnPerRoute = 5; //


    @Bean(name="externalRestTemplate")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(clientHttpRequestFactory()));
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        //HttpComponentsClientHttpRequestFactory는 keep alive.
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        //connection pool설정
        clientHttpRequestFactory.setHttpClient(HttpClientBuilder.create()
            .setMaxConnTotal(maxConnTotal)
            .setMaxConnPerRoute(maxConnPerRoute)
            .setConnectionTimeToLive(maxConnPerRoute, TimeUnit.SECONDS)
            .build());
        clientHttpRequestFactory.setConnectTimeout(connectTimeout * 1000);
        clientHttpRequestFactory.setReadTimeout(readTimeout * 1000);
        return clientHttpRequestFactory;
    }
}
