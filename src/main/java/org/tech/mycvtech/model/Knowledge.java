package org.tech.mycvtech.model;

public class Knowledge {
    String name;
    Level level;

    public Knowledge(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public Knowledge(String name) {
        this(name, Level.ZERO);
    }

    public Knowledge() {
        this("");
    }
}
