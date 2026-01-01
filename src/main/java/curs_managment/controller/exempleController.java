package curs_managment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class exempleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, it's a test ! thank you :)";
    }
    


}
