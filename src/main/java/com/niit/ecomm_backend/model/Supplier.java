package com.niit.ecomm_backend.model;

import java.io.Serializable;
import java.util.List;
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
@Table(name="Supplier")
public class Supplier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private Set<Product> set_of_products;
	@Id
	@GeneratedValue
	@Column(name="supplier_id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="supplier_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(targetEntity=Product.class, mappedBy="supplier", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="supplier_set_of_products")
	public Set<Product> getSet_of_products() {
		return set_of_products;
	}
	public void setSet_of_products(Set<Product> set_of_products) {
		this.set_of_products = set_of_products;
	}
	

}
