package ru.education.recommendationClient.model;

public enum ServiceType {
    ANIME("anime");

    private final String serviceName;

    ServiceType(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
