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
import com.niit.ecomm_backend.dao.SupplierDao;
import com.niit.ecomm_backend.model.Supplier;;

@Repository
public class SupplierImpl implements SupplierDao{

	private Session currentSession;
	private Transaction currentTransaction;
	
	//private SessionFactory sessionFactory;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void persist(Supplier entity) {
		getCurrentSession().save(entity);		
	}
	
	@Override
	public void update(Supplier entity) {
		getCurrentSession().update(entity);
		
	}
	
	@Override
	public Supplier findById(int id) {
		Supplier supplier = (Supplier) getCurrentSession().get(Supplier.class, id);
		return supplier;
	}
	
	@Override
	public void delete(Supplier entity) {
		getCurrentSession().delete(entity);		
	}
	
	@Override
	public List<Supplier> findAll() {
		List<Supplier> suppliers = (List<Supplier>) getCurrentSession().createQuery("from Supplier").list();
		return suppliers;
	}
	
	@Override
	public void deleteAll() {
		List<Supplier> entityList = findAll();
		for (Supplier entity : entityList) {
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
