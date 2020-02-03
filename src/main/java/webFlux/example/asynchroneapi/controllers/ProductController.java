package webFlux.example.asynchroneapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webFlux.example.asynchroneapi.entities.Product;
import webFlux.example.asynchroneapi.services.IServiceProduct;


@RestController
public class ProductController {
	@Autowired
	IServiceProduct serviceProduct;
	
	@GetMapping("/getAll")
	public Flux<Product> getAllCricketers() {
		return serviceProduct.getAllProducts();
	}
	
	@GetMapping("/getOne/{id}")
	public Mono<ResponseEntity<Product>> getCricketer(@PathVariable("id") int id) {
		return serviceProduct.getOneProduct(id)
			     .map(ResponseEntity::ok)
			     .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}	

	@PostMapping("/add")
	public Mono<Product> addCricketer(@RequestBody Product product) {
		return serviceProduct.addProduct(product);
	}
	
	@PostMapping("/update/{id}")
	public Mono<ResponseEntity<Product>> updateCricketer(@RequestBody Product product) {
		return serviceProduct.updateProduct(product)
		.map(updatedProduct -> new ResponseEntity<Product>(updatedProduct, HttpStatus.OK))
		.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/api/cricketer/{id}")
	public Mono<ResponseEntity<Void>> deleteCricketer(@PathVariable("id") int id) {
		return serviceProduct.deleteProduct(id).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
	}
}
