package com.br.tresemeia.courseUdemy.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tresemeia.courseUdemy.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	//método endpoint para acessar os usuários
	//ResponseEntity: tipo específico de retorno do 
	//spring boot para retornar respostas  de requisições web
	//GetMapping: indica que é um método que responde o tipo GET do HTTP
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Juliano", "proprietyofkur@hotmail.com", "9999999", "123456");
		//.ok(): retorna a resposta com sucesso
		//.body(u): retorna para o corpo da resposta o usuário u
		return ResponseEntity.ok().body(u);
	}

}
