package ru.education.recommendationClient.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.recommendationClient.model.Record;
import ru.education.recommendationClient.model.ServiceType;
import ru.education.recommendationClient.services.RecommendationService;

@RestController
@RequestMapping(path = "${app.rest.api.prefix}/v1")
public class RecommendationRestV1 {

    private final RecommendationService service;

    @Autowired
    public RecommendationRestV1(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/recommendation/{type}/{filter}")
    public ResponseEntity<Record> getRecommendation(@PathVariable("type") ServiceType type,
                                                    @PathVariable("filter") String filter) {
        return ResponseEntity.ok(service.getRecommendation(type, filter));
    }
}
