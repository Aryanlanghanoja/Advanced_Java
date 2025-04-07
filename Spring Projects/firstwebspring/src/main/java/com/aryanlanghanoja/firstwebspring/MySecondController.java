package com.aryanlanghanoja.firstwebspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysecond")
public class MySecondController {

    @GetMapping("/")
    public String mySecondGreet() {
        return "This is my second endpoint Grettings";
    }
    @GetMapping("/myend")
    public String mySecondMethod() {
        return "This is my second endpoint";
    }
}
