package com.br.tresemeia.courseUdemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tresemeia.courseUdemy.entities.OrderItem;

//Solicita entidade e ID
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
