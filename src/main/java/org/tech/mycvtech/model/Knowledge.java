package org.tech.mycvtech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Knowledge {
    @JsonProperty("name")
    String name;
    @JsonProperty("level")
    Level level;

    public Knowledge(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public Knowledge(String name) {
        this(name, Level.ZERO);
    }

    public Knowledge() {
    }
}
