package com.br.tresemeia.courseUdemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tresemeia.courseUdemy.entities.Order;
import com.br.tresemeia.courseUdemy.repositories.OrderRepository;

//@Service: injeta a classe automaticamente no spring boot como uma classe da camada de serviço
@Service
public class OrderService {
	
	//@Autowired: para que o springboot faça a injeção de transparência de forma transparente
	@Autowired
	//Necessário a dependência da camada do servidor(data repositories)
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	//Retorna um objeto Optional do tipo Order
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
