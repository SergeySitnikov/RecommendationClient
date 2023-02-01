package ru.education.recommendationClient.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private String name;

    private String synopsis;

    private String ageRating;

    private final Map<String, String> attributes = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @JsonAnyGetter
    public Map<String, String> getAttributes() {
        return attributes;
    }


    @JsonAnySetter
    public void setOtherField(String name, String value) {
        attributes.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record record)) return false;

        if (!getName().equals(record.getName())) return false;
        if (!getSynopsis().equals(record.getSynopsis())) return false;
        if (!getAgeRating().equals(record.getAgeRating())) return false;
        return getAttributes() != null ? getAttributes().equals(record.getAttributes()) : record.getAttributes() == null;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSynopsis().hashCode();
        result = 31 * result + getAgeRating().hashCode();
        result = 31 * result + (getAttributes() != null ? getAttributes().hashCode() : 0);
        return result;
    }
}
