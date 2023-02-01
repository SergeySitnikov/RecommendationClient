package ru.education.recommendationClient.client;

import org.springframework.stereotype.Service;
import ru.education.recommendationClient.exceptions.HttpClientException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class BasicHttpClient implements HttpClient {
    @Override
    public String performRequest(String uri) {
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            throw new HttpClientException("Can't send request to client", e);
        }
    }
}
