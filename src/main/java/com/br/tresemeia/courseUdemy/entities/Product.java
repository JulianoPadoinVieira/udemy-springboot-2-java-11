package com.br.tresemeia.courseUdemy.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Table(name = "tb_product")
public class Product {	
	
	private static final long serialVersionUID = 1L;
	
	@Id //Chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto increment
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	/* 
		Nesse caso especifico não usamos lista, usaremos "Set" que representa um conjunto para
		garantir que não teremos um produto com mais de uma ocorrência da mesma categoria, ou seja
		o mesmo produto não pode ter mais uma mesma categoria mais de uma vez. 
			OBS: para garantir que a coleção inicie vazia e NÃO nula colocamos o new HashSet<>()
			OBS2: não podemos instanciar o set, por isso o HashSet
	*/	
	@ManyToMany //Muitos para muitos entre Product e Category
	//name: nome da tabela de associação do banco de dados
	//joinColumns: nome da chave estrangeira referente a tabela de product
	//@JoinColumn: annotation do JPA (nome da chave estrangeira do produto)
	//inverseJoinColumns: chave estrangeira da outra entidade
	@JoinTable(name = "tb_product_category", 
	joinColumns = @JoinColumn(name = "product_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	public Product() {
		
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
