package com.aryanlanghanoja.firstwebspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping(value = "/{name}")
    public String Greetings(@PathVariable String name) {
        return "Greetings from Aryan Langhanoja to " + name + "!";
    }

    @GetMapping("/hii")
    public String Hii() {
        return "Hii from Aryan Langhanoja!";
    }
    
}
