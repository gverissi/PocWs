package com.example.pocws.ws;

import com.example.pocws.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWS {

    @GetMapping("/hello")
    public String disHello() {
        return "coucou";
    }

    @GetMapping("/hello/{langue}")
    public String disHelloLang(@PathVariable("langue") String langue) {
        if (langue.equals("fr")) {
            return "coucou";
        } else {
            return "hello";
        }
    }

    @GetMapping("/person")
    public Person getPerson() {
        return new Person("gregag", 38);
    }

}
