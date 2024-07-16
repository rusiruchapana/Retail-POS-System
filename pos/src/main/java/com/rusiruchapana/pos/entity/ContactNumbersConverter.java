package com.rusiruchapana.pos.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.ArrayList;

public class ContactNumbersConverter implements AttributeConverter<ArrayList , String> {
    @Override
    public String convertToDatabaseColumn(ArrayList contactNumbers) {
        if (contactNumbers == null) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(contactNumbers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting contact numbers to JSON", e);
        }
    }

    @Override
    public ArrayList convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(dbData, new TypeReference<ArrayList<String>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to contact numbers", e);
        }
    }
}
