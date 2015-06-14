package de.loonymonkey.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaygroundApplication {

    public static void main(final String[] args) {
        final SpringApplication application = new SpringApplication(PlaygroundApplication.class);
        application.run(args);
    }
}
