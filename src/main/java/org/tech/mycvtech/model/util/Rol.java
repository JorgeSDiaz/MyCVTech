package org.tech.mycvtech.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Rol implements Serializable {
    @JsonProperty("name")
    String name;
}

