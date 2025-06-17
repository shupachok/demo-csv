package com.ex.democsv.model;

import com.opencsv.bean.CsvBindByName;

public class CsvData {

    @CsvBindByName(column = "ID")
    private String id;

    @CsvBindByName(column = "NAME")
    private String name;

    @CsvBindByName(column = "EMAIL")
    private String email;

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