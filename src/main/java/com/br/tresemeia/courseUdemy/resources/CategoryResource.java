package com.br.tresemeia.courseUdemy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tresemeia.courseUdemy.entities.Category;
import com.br.tresemeia.courseUdemy.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//método endpoint para acessar os usuários
	//ResponseEntity: tipo específico de retorno do 
	//spring boot para retornar respostas  de requisições web
	//GetMapping: indica que é um método que responde o tipo GET do HTTP
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		//.ok(): retorna a resposta com sucesso
		//.body(list): retorna para o corpo da resposta a lista de usuários list
		return ResponseEntity.ok().body(list);
	}

	//Para passar no URL a id do usuário
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	
	
	
	
	
	
	
}
