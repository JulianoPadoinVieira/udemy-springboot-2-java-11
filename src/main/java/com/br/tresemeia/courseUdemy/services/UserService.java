package com.br.tresemeia.courseUdemy.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.tresemeia.courseUdemy.entities.User;
import com.br.tresemeia.courseUdemy.repositories.UserRepository;
import com.br.tresemeia.courseUdemy.services.exceptions.DatabaseException;
import com.br.tresemeia.courseUdemy.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		} catch(RuntimeException e)	{ //Usamos isso para capturar o erro gerado
			e.printStackTrace();
		}		
	}
	
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}
