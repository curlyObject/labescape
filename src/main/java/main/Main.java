package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Entry point for the java program.
 *
 * Creates and starts the spring web main.service
 */
@SpringBootApplication
@EnableWebMvc
public class Main extends WebMvcAutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
