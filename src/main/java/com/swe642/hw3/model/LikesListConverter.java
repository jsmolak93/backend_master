package com.swe642.hw3.model;

/**
 * Converts the likes array in the REST json message to/from
 * enumerated values that are used in the database
 * @author Russell Bisker, Jonathan Hus, John Smolak
 */

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LikesListConverter implements AttributeConverter<List<Likes>, String> {
    @Override
    public String convertToDatabaseColumn(List<Likes> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        return attribute.stream()
                .map(Likes::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public List<Likes> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return Arrays.stream(dbData.split(","))
                .map(Likes::valueOf)
                .collect(Collectors.toList());
    }
}
