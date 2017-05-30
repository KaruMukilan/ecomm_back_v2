package com.niit.ecomm_backend.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ecomm_backend.dao.ProductDao;
import com.niit.ecomm_backend.model.Product;


@Repository
public class ProductImpl implements ProductDao{

	private Session currentSession;
	private Transaction currentTransaction;
	//private SessionFactory sessionFactory;
	
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public void persist(Product entity) {
		getCurrentSession().save(entity);		
	}
	
	@Override
	public void update(Product entity) {
		getCurrentSession().update(entity);
		
	}
	
	@Override
	public Product findById(int id) {
		Product product = (Product) getCurrentSession().get(Product.class, id);
		return product;
	}
	
	@Override
	public void delete(Product entity) {
		getCurrentSession().delete(entity);		
	}
	
	@Override
	public List<Product> findAll() {
		List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();
		return products;
	}
	
	@Override
	public void deleteAll() { 
		List<Product> entityList = findAll();
		for (Product entity : entityList) {
			delete(entity);
		}
	}
	
	public Session openCurrentSession() {
		currentSession = sessionFactory.openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = sessionFactory.openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
/*	public SessionFactory setSessionFactory(SessionFactory sessionFactory){
		return sessionFactory;
	}*/
}
