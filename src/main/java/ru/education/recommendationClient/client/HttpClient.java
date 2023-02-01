package ru.education.recommendationClient.client;

import java.io.IOException;

public interface HttpClient {
    String performRequest(String uri);
}
