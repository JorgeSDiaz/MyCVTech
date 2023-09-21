package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Rol implements Serializable {
    @JsonProperty("name")
    String name;

    public Rol(String name) {
        this.name = name;
    }

    public Rol() {

    }
}

