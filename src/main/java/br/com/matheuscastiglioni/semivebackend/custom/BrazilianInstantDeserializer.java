package br.com.matheuscastiglioni.semivebackend.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class BrazilianInstantDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            if (this.hasData(jsonParser)) {
                Instant date = Instant.now();
                String data = jsonParser.getText();
                if (this.dataIsFull(data)) {
                    date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(jsonParser.getText()).toInstant();
                } else if (this.dataIsDate(data)) {
                    date = new SimpleDateFormat("dd/MM/yyyy").parse(jsonParser.getText()).toInstant();
                } else if (this.dataIsHour(data)) {
                    date = new SimpleDateFormat("HH:mm").parse(jsonParser.getText()).toInstant();
                }
                return date;
            } else {
                return null;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean dataIsHour(String data) {
        return data.contains("/") && data.contains(":");
    }

    private boolean dataIsDate(String data) {
        return data.contains("/") && !data.contains(":");
    }

    private boolean dataIsFull(String data) {
        return !data.contains("/") && data.contains(":");
    }

    private boolean hasData(JsonParser jsonParser) throws IOException {
        return jsonParser.getText() != null && !jsonParser.getText().equals("");
    }

}
