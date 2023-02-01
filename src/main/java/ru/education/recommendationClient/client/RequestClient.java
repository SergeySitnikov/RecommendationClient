package ru.education.recommendationClient.client;

import ru.education.recommendationClient.model.Record;

import java.io.IOException;

public interface RequestClient {
    Record sendRequest(String filter);
}
