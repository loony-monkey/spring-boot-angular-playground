package de.loonymonkey.playground.hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import de.loonymonkey.playground.PlaygroundApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PlaygroundApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class HelloControllerIT {
    @Value("${local.server.port}")
    private int          port;
    private URL          base;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + this.port + "/hello");
        this.template = new TestRestTemplate();
    }

    @Test
    public void getHello() throws Exception {
        final ResponseEntity<String> response = this.template.getForEntity(this.base.toString(), String.class);
        assertThat(response.getBody(), equalTo("Greetings from Loony Monkey's 'Spring Boot AngularJS Playground'!"));
    }
}
