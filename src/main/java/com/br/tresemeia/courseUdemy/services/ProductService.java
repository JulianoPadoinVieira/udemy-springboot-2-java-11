package com.br.tresemeia.courseUdemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tresemeia.courseUdemy.entities.Product;
import com.br.tresemeia.courseUdemy.repositories.ProductRepository;

//@Service: injeta a classe automaticamente no spring boot como uma classe da camada de serviço
@Service
public class ProductService {
	
	//@Autowired: para que o springboot faça a injeção de transparência de forma transparente
	@Autowired
	//Necessário a dependência da camada do servidor(data repositories)
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	//Retorna um objeto Optional do tipo Product
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
