package webFlux.example.asynchroneapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webFlux.example.asynchroneapi.entities.Product;
import webFlux.example.asynchroneapi.reposytories.ProductRepository;



@Service(value = "productService")
public class ServiceProductIMPL implements IServiceProduct {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Mono<Product> addProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Mono<Product> getOneProduct(int id) {
		return productRepository.findById(id);
	}

	@Override
	public Flux<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Mono<Product> updateProduct(Product p) {
			return productRepository.save(p);
	}

	@Override
	public Mono<Void> deleteProduct(int id) {
		return productRepository.deleteById(id);		
	}
	

}
