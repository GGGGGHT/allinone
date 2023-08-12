package com.ggggght.service.service;

import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MiscService {
    @GetExchange("/books")
    Mono<List<Integer>> getBooks();
}
