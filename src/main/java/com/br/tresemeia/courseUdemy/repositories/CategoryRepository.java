package com.br.tresemeia.courseUdemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tresemeia.courseUdemy.entities.Category;

//Solicita entidade e ID
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
