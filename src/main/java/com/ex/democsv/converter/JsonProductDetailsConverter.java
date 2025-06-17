package com.ex.democsv.converter;

import com.ex.democsv.model.ProductDetail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.util.List;

public class JsonProductDetailsConverter extends AbstractBeanField<List<ProductDetail>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        try {
            return objectMapper.readValue(value, new TypeReference<List<ProductDetail>>() {});
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException("Failed to parse JSON for ProductDetails");
        }
    }
}