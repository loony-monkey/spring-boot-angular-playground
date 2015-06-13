package de.loonymonkey.playground.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String home() {
        return "Greetings from Loony Monkey's 'Spring Boot AngularJS Playground'!";
    }
}
