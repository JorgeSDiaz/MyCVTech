package org.tech.mycvtech.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Knowledge {
    @JsonProperty("name")
    String name;
    @JsonProperty("level")
    Level level;

    public Knowledge(String name) {
        this(name, Level.ZERO);
    }

}
