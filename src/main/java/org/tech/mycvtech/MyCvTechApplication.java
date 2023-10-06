package org.tech.mycvtech;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class MyCvTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCvTechApplication.class, args);
    }

}
