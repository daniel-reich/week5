package springRest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRestController {

//we are building the HTML file content here, rather than having an actual jsp!

    @RequestMapping("/")
    public String index() {
        return "<h1>Greetings from Spring Boot!</h1>";
    }

    @RequestMapping("/test")
    public String test() {
        return "<h1>This is a test...</h1>";
    }
}

