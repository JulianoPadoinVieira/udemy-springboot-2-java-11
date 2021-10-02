package com.br.tresemeia.courseUdemy.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Basic entity checklist:
	* Basic attributes
    * Associations (instantiate collections)    	
	* Constructors
	* Getters & Setters (collections: only get)
	* hashCode & equals (pode ser somente para o ID como nesse caso)
	* Serializable (a classe "implements Serializable", 
		* obrigatório: 
			* private static final long serialVersionUID = 1L)
 */

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
	private Long id;
	private String name;
	
	//mappedBy: nome da coleção que tem na outra classe(Product)
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore
	private Set<Product> products = new HashSet<>();
	
	public Category() {		
		
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Product> getProducts() {
		return products;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}	

}
