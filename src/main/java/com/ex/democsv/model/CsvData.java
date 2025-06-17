package com.ex.democsv.model;

import com.ex.democsv.converter.JsonProductDetailsConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.util.List;

public class CsvData {

    @CsvBindByName(column = "ID")
    private String id;

    @CsvBindByName(column = "NAME")
    private String name;

    @CsvBindByName(column = "EMAIL")
    private String email;

    @CsvCustomBindByName(column = "DETAILS", converter = JsonProductDetailsConverter.class)
    private List<ProductDetail> details;

    public List<ProductDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetail> details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}