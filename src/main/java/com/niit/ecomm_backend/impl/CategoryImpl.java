package com.niit.ecomm_backend.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.niit.ecomm_backend.AppConfiguration;
import com.niit.ecomm_backend.dao.CategoryDao;
import com.niit.ecomm_backend.model.Category;;

@Repository
public class CategoryImpl implements CategoryDao{

	private Session currentSession;
	private Transaction currentTransaction;
	//private SessionFactory sessionFactory;
	
	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public void persist(Category entity) {
		getCurrentSession().save(entity);		
	}
	
	@Override
	public void update(Category entity) {
		getCurrentSession().update(entity);
		
	}
	
	@Override
	public Category findById(int id) {
		Category product = (Category) getCurrentSession().get(Category.class, id);
		return product;
	}
	
	@Override
	public void delete(Category entity) {
		getCurrentSession().delete(entity);		
	}
	
	@Override
	public List<Category> findAll() {
		List<Category> categories = (List<Category>) getCurrentSession().createQuery("from Category").list();
		return categories;
	}
	
	@Override
	public void deleteAll() { 
		List<Category> entityList = findAll();
		for (Category entity : entityList) {
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
	//@Autowired
	/*
	public SessionFactory setSessionFactory(SessionFactory sessionFactory){
		return sessionFactory;
	}*/
}
