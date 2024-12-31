package com.ecommerce.productservicenovermber2024.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")

public class SampleController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/bye")
    public String sayGoodbye() {
        return "Goodbye World";
    }
}
