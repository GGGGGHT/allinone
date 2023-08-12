package com.ggggght.misc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class MiscController {
    @RequestMapping("/misc")
    public String misc() {
        return "misc";
    }

    @GetMapping("/books")
    public List<Integer> books() {
        return List.of(1, 2, 3);
    }
}
