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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int orderId;
	//private int userId;
	private User userId;
	private double orderTotal;
	private String payment;
	@Id
	@GeneratedValue
	@Column(name="id")
	public int geOrdertId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	//@Column(name="order_user_id")
	@ManyToOne
	//@JoinColumn(name="orders")	
	@JoinColumn(name="userId")	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Column(name="total")
	public double getTotal(){
		return orderTotal;
	}
	public void setTotal(double orderTotal){
		this.orderTotal=orderTotal;
	}
	@Column(name="payment")
	public String getPayment(){
		return payment;
	}
	public void setPayment(String payment){
		this.payment=payment;		
	}	
}
