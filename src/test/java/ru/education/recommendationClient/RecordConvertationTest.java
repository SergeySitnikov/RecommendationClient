package ru.education.recommendationClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.education.recommendationClient.client.HttpClient;
import ru.education.recommendationClient.client.RequestClient;
import ru.education.recommendationClient.model.Record;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RecordConvertationTest {

    private final RequestClient requestClient;

    @MockBean
    private HttpClient client;

    @Autowired
    public RecordConvertationTest(RequestClient requestClient) {
        this.requestClient = requestClient;
    }

    @Test
    public void testConvertAnimeJsonRecordToResponseRecord() throws Exception {
        var uri = ClassLoader.getSystemResource("anime_record_response.json").toURI();
        var recordJson = Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
        when(client.performRequest(any())).thenReturn(recordJson);
        Record actual = requestClient.sendRequest(any());
        Record expected = new Record();
        expected.setName("Tokyo Ghoul");
        expected.setSynopsis("Tokyo has become a cruel and merciless city—a place where vicious creatures called “ghouls”...");
        expected.setAgeRating("R");
        expected.setOtherField("episodesCount", "12");
        Assertions.assertEquals(expected, actual);
    }
}
