package webFlux.example.asynchroneapi.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webFlux.example.asynchroneapi.entities.Product;

public interface IServiceProduct {
	public Mono<Product> addProduct(Product p);
	public Mono<Product> getOneProduct(int id);
	public Flux<Product> getAllProducts();
	public Mono<Product> updateProduct(Product p);
	public Mono<Void> deleteProduct(int id);
}
