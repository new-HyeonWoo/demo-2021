package com.example.demo.common.config.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class RestTemplateConfiguration {

    final private int CONNECT_TIME_OUT_SEC = 15;
    final private int READ_TIME_OUT_SEC = 30;

//    @Value("${}")
//    private Duration connecetTimeout;
//
//    @Value("${}")
//    private Duration readTimeout;
//
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplateBuilder()
////                .interceptors()
////                .requestFactory()
//                .setConnectTimeout(connecetTimeout)
//                .setReadTimeout(readTimeout)
//                .build();
//    }
//
//    public HttpComponentsClientHttpRequestFactory factory() {
//        CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setMaxConnTotal(120) // maxConnTotal은 연결을 유지할 최대 숫자
//                .setMaxConnPerRoute(60) // maxConnPerRoute는 특정 경로당 최대 숫자
//                .setConnectionTimeToLive(5, TimeUnit.SECONDS) // keep - alive
//                .build();
//
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        return factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
//    }

//    @Bean(name="keepAliveRestTemplate")
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory())
//        return null;
//    }
//
//    @Bean
//    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        clientHttpRequestFactory.setHttpClient(HttpClien);
//        clientHttpRequestFactory.setConnectTimeout(CONNECT_TIME_OUT_SEC * 1000);
//        clientHttpRequestFactory.setReadTimeout(READ_TIME_OUT_SEC * 1000);
//    }

}
