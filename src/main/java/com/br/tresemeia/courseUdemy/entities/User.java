package com.br.tresemeia.courseUdemy.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

 * H2 database, test profile, JPA
	* JPA & H2 dependencies (no pom.xml)
	* application.properties (spring.profiles.active=test spring.jpa.open-in-view=true)
	* application-test.properties (criar e configurar o arquivo)
	* Entity: JPA mapping (@Entity, @Id e @GeneratedValue)
 */

@Entity
public class User implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	//Construtor padrão
	public User() {
		
	}

	//Construtor com todos atributos
	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
