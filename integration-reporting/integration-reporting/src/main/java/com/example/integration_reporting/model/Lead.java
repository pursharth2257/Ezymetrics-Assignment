package com.example.integration_reporting.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Lead {
    @Id
    private String id;
    private String name;
    private String email;
    private String source;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }


    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
}