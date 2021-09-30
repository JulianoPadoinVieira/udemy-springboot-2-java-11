package com.br.tresemeia.courseUdemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tresemeia.courseUdemy.entities.Order;

//Solicita entidade e ID
public interface OrderRepository extends JpaRepository<Order, Long> {

}
