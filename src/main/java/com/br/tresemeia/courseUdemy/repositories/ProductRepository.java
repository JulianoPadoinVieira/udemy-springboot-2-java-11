package com.br.tresemeia.courseUdemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tresemeia.courseUdemy.entities.Product;

//Solicita entidade e ID
public interface ProductRepository extends JpaRepository<Product, Long> {

}
