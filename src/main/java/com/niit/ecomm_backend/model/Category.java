package com.niit.ecomm_backend.model;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	//private List<String> set_of_products;
	private Set<Product> set_of_products;
	@Id
	@GeneratedValue
	@Column(name="category_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="category_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(targetEntity=Product.class, mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="category_set_of_products")
	public Set<Product> getSet_of_products() {
		return set_of_products;
	}
	public void setSet_of_products(Set<Product> set_of_products) {
		this.set_of_products = set_of_products;
	}
/*	@Column(name="category_set_of_products")
	public List<String> getSet_of_products() {
		return set_of_products;
	}
	public void setSet_of_products(List<String> set_of_products) {
		this.set_of_products = set_of_products;
	}*/
	
}
