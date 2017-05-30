package com.niit.ecomm_backend.model;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Product")
public class Product implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	private int id;
	private String name;
	private Category category;
	private String brand;
	private double price;
	private Supplier supplier;
	private String description;
	//private List<Part> image;
	private String imageName;
	private Blob image; 
	private String imageType;
	private int quantity;
	
	public Product(){}

	public Product(String name, Category category, String brand, double price, Supplier supplier,
			String description, Blob image, int quantity) {
		super();
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.supplier = supplier;
		this.description = description;
		this.image = image;
		this.quantity = quantity;
	}
	@Id
	@GeneratedValue
	@Column(name="product_id")
	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="product_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//@Column(name="product_category")
	@ManyToOne
	@JoinColumn(name="category_id")
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Column(name="product_brand")
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Column(name="product_price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	//@Column(name="product_supplier")
	@ManyToOne
	@JoinColumn(name="supplier_id")
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@Column(name="product_Description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*
	public List<Part> getImage() {
		return image;
	}
	public void setImage(List<Part> image) {
		this.image = image;
	}
	*/
	
	@Column(name="product_image_name")
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}	
	@Column(name="product_image_type")
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}	
	@Column(name="product_image")
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	@Column(name="product_quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString(){
		return this.id + " " + this.name + " " + this.brand + " " + this.category + " " + this.price + " " + this.supplier + " " + this.description + " " + this.image + " " + this.quantity;
	}
	
	 
}
