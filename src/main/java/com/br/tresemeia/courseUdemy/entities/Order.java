package com.br.tresemeia.courseUdemy.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Basic entity checklist:
	* Basic attributes
    * Associations (instantiate collections)
    	*OBS: como é a primeira entidade, não tem associação 
	* Constructors
	* Getters & Setters (collections: only get)
	* hashCode & equals (pode ser somente para o ID como nesse caso)
	* Serializable (a classe "implements Serializable", 
	* obrigatório: 
		* private static final long serialVersionUID = 1L)
*/
@Entity
@Table(name = "tb_order") //Nome da tabela, nesse caso obrigatório por causa do conflito de nome
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
	private Long id;
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id") //Chave estrangeira
	private User client;
	
	public Order() {
		
	}

	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
