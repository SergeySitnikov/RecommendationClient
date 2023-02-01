package ru.education.recommendationClient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.recommendationClient.client.RequestClient;
import ru.education.recommendationClient.model.Record;
import ru.education.recommendationClient.model.ServiceType;

import java.util.Map;

@Service
public class RecommendationService {
    private final Map<String, RequestClient> clients;

    @Autowired
    public RecommendationService(Map<String, RequestClient> clients) {
        this.clients = clients;
    }

    public Record getRecommendation(ServiceType type, String filter) {
        return clients.get(type.getServiceName()).sendRequest(filter);
    }
}
