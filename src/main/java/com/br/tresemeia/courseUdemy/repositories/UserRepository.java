package com.br.tresemeia.courseUdemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tresemeia.courseUdemy.entities.User;

//Solicita entidade e ID
public interface UserRepository extends JpaRepository<User, Long> {

}
