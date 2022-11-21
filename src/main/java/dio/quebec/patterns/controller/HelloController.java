package dio.quebec.patterns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("/")
@Hidden
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello DIO... Patterns Project!";
    }
}
