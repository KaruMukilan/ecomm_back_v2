package com.niit.ecomm_backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name="Cart")
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int cartId;
	private Product productId;
	private Supplier supplierId;
	private User userId;
	private double price;
	private boolean status;
	private int quantity;
	@Id
	@GeneratedValue
	@Column(name="cartId")
	public int getId() {
		return cartId;
	}
	public void setId(int id) {
		this.cartId = cartId;
	}
	//@Column(name="cart_product_id")
	@ManyToOne
	@JoinColumn(name="productId")
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	//@Column(name="cart_supplier_id")
	@OneToOne
	@JoinColumn(name="supplierId")
	public Supplier getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}
	//@Column(name="cart_user_id")
	@OneToOne
	@JoinColumn(name="userId")
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name="status")
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
