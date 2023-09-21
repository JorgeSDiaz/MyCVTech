package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SoftSkill {
    @JsonProperty("name")
    String name;

    public SoftSkill(String name) {
        this.name = name;
    }

    public SoftSkill() {
    }
}
