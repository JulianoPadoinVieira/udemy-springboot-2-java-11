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
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
	public User update(Long id, User obj) {
		User entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}
