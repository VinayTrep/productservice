package com.example.productservice.client;

import com.example.productservice.client.dto.ValidateRequestDto;
import com.example.productservice.model.SessionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class UserServiceClient {


    private final RestClient restClient;
    @Value("${userservice.base.url}")
    private String baseUrl;

    @Value("${userservice.validate.url}")
    private String validateUrl;

    public UserServiceClient() {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public SessionType validate(ValidateRequestDto requestDto){

        String uri = UriComponentsBuilder
                .fromUriString(validateUrl)
                .toUriString();

        return restClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestDto)
                .retrieve()
                .body(SessionType.class);

    }
}
