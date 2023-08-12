package com.ggggght.service.controller;

import com.ggggght.service.service.MiscService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class HelloController {
    Logger log = LoggerFactory.getLogger(HelloController.class);
    MiscService service;


    @GetMapping("/hello")
    public Mono<List<Integer>> hello() {
        return service.getBooks();
    }

    public HelloController(MiscService service) {
        this.service = service;
    }
}
