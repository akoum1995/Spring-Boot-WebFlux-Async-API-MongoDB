package webFlux.example.asynchroneapi.reposytories;

import webFlux.example.asynchroneapi.entities.Product;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
//import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository  extends ReactiveMongoRepository<Product, Integer>{

}
