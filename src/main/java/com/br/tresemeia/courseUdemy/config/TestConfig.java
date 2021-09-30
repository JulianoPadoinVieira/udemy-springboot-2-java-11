package com.br.tresemeia.courseUdemy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.br.tresemeia.courseUdemy.entities.Order;
import com.br.tresemeia.courseUdemy.entities.User;
import com.br.tresemeia.courseUdemy.entities.enums.OrderStatus;
import com.br.tresemeia.courseUdemy.repositories.OrderRepository;
import com.br.tresemeia.courseUdemy.repositories.UserRepository;

@Configuration
@Profile("test")
//CommandLineRunner: para executar esta classe toda vez que a aplicação iniciar
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		// Passado:
		//id: Nulo(é auto increment no banco)
		//Instant.parse: String no formato ISO 8601
		//Usuário: u1 e u2 previamente criado
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
