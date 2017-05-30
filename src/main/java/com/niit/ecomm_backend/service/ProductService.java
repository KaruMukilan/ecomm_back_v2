package com.niit.ecomm_backend.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.niit.ecomm_backend.dao.ProductDao;
import com.niit.ecomm_backend.dao.Dao;
import com.niit.ecomm_backend.impl.ProductImpl;
import com.niit.ecomm_backend.model.Product;

@Service
public class ProductService implements Dao<Product>{
	@Autowired
	private ProductImpl productImpl;

/*	public ProductService() {
		productImpl = new ProductImpl();
	}*/

	public void persist(Product entity) {
		productImpl.openCurrentSessionwithTransaction();
		productImpl.persist(entity);
		productImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Product entity) {
		productImpl.openCurrentSessionwithTransaction();
		productImpl.update(entity);
		productImpl.closeCurrentSessionwithTransaction();
	}

	public Product findById(int id) {
		productImpl.openCurrentSession();
		Product Product = productImpl.findById(id);
		productImpl.closeCurrentSession();
		return Product;
	}

	public void delete(Product entity) {
		productImpl.openCurrentSessionwithTransaction();
		productImpl.delete(entity);
		productImpl.closeCurrentSessionwithTransaction();
	}

	public List<Product> findAll() {
		productImpl.openCurrentSession();
		List<Product> Products = productImpl.findAll();
		productImpl.closeCurrentSession();
		return Products;
	}

	public void deleteAll() {
		productImpl.openCurrentSessionwithTransaction();
		productImpl.deleteAll();
		productImpl.closeCurrentSessionwithTransaction();
	}

	public ProductImpl getproductImpl() {
		return productImpl;
	}
	public Session getCurrentSession(){
		return productImpl.getCurrentSession();
	}


}
