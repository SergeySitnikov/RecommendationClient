package ru.education.recommendationClient.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.recommendationClient.config.AnimeClientConfig;
import ru.education.recommendationClient.exceptions.JsonParseException;
import ru.education.recommendationClient.model.Record;

@Service("anime")
public class AnimeRequestClient implements RequestClient {

    private final AnimeClientConfig config;

    private final HttpClient httpClient;

    private final ObjectMapper objectMapper;

    @Autowired
    public AnimeRequestClient(AnimeClientConfig config, HttpClient httpClient, ObjectMapper objectMapper) {
        this.config = config;
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Record sendRequest(String filter) {
        var response = httpClient.performRequest(config.getUrl() + filter);
        try {
            return objectMapper.readValue(response, Record.class);
        } catch (Exception ex) {
            throw new JsonParseException("Failed to convert JSON response from service. Filter:" + filter, ex);
        }
    }
}
