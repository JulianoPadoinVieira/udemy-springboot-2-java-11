package com.br.tresemeia.courseUdemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tresemeia.courseUdemy.entities.Category;
import com.br.tresemeia.courseUdemy.repositories.CategoryRepository;

//@Service: injeta a classe automaticamente no spring boot como uma classe da camada de serviço
@Service
public class CategoryService {
	
	//@Autowired: para que o springboot faça a injeção de transparência de forma transparente
	@Autowired
	//Necessário a dependência da camada do servidor(data repositories)
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	//Retorna um objeto Optional do tipo Category
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
