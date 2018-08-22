package com.example.demo.repository;

import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.demo.model.Product;
import reactor.core.publisher.Flux;

public interface ProductRepository
extends ReactiveMongoRepository<Product, String> {

//    Flux<Product> findByNameOOrderByPrice(Publisher<String> name);

}
