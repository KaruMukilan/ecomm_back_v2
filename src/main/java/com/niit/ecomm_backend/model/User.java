package com.niit.ecomm_backend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int userId;
	private String name;
	private String email;
	private String password;
	private String role;
	private boolean isEnabled;
	private Cart cartId;	
	private Set<Order> orders;
	@Id
	@GeneratedValue
	@Column(name="userId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int id) {
		this.userId = userId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="isEnabled")
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	@OneToOne
	@JoinColumn(name="cartId")
	//@Column(name="user_cart_id")
	public Cart getCartId() {
		return cartId;
	}
	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}
	//@Column(name="user_orders")
	@OneToMany(targetEntity=Order.class,mappedBy="userId", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	//@JoinColumn(name="user_id")
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}	
}
