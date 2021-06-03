package com.example.pocws.ws;

import com.example.pocws.entity.Chuck;
import com.example.pocws.entity.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return new Person("gregag", "38");
    }

    @GetMapping("/go")
    public List<Person> consumeWS(RestTemplate restTemplate) {
        ResponseEntity<Person[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/persons", Person[].class);
        Person[] personArray = responseEntity.getBody();
        assert personArray != null;
        return Arrays.stream(personArray).collect(Collectors.toList());
    }

    @GetMapping("/chuck")
    public Chuck chuckNorris(RestTemplate restTemplate) {
        Chuck chuck = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Chuck.class);
        System.out.println(chuck);
        assert chuck != null;
        return chuck;
    }

}
