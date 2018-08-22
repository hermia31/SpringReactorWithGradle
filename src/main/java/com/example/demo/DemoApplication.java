package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


@Bean
	CommandLineRunner init(ProductRepository repository){
		return args -> {
			Flux<Product> productFlux= Flux.just(
					new Product(null,"ice cream",3.99),
			        new Product(null,"toys",9.99),
			        new Product(null,"chocolate",4.56)).flatMap(repository::save);
//					.flatMap(p ->repository.save(p));

			     productFlux
						 .thenMany(repository.findAll())//then many takes both publisher and mono ; then takes only mono
		                 .subscribe(System.out::println);
		};
}



}
