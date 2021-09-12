package com.br.tresemeia.courseUdemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tresemeia.courseUdemy.entities.User;
import com.br.tresemeia.courseUdemy.repositories.UserRepository;

//@Service: injeta a classe automaticamente no spring boot como uma classe da camada de serviço
@Service
public class UserService {
	
	//@Autowired: para que o springboot faça a injeção de transparência de forma transparente
	@Autowired
	//Necessário a dependência da camada do servidor(data repositories)
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	//Retorna um objeto Optional do tipo User
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
