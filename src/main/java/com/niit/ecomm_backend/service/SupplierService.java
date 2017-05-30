package com.niit.ecomm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.niit.ecomm_backend.dao.SupplierDao;
import com.niit.ecomm_backend.dao.Dao;
import com.niit.ecomm_backend.impl.SupplierImpl;
import com.niit.ecomm_backend.model.Supplier;

@Service
public class SupplierService implements Dao<Supplier>{
	@Autowired
	private SupplierImpl supplierImpl;

/*	public SupplierService() {
		supplierImpl = new SupplierImpl();
	}*/

	public void persist(Supplier entity) {
		supplierImpl.openCurrentSessionwithTransaction();
		supplierImpl.persist(entity);
		supplierImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Supplier entity) {
		supplierImpl.openCurrentSessionwithTransaction();
		supplierImpl.update(entity);
		supplierImpl.closeCurrentSessionwithTransaction();
	}

	public Supplier findById(int id) {
		supplierImpl.openCurrentSession();
		Supplier Supplier = supplierImpl.findById(id);
		supplierImpl.closeCurrentSession();
		return Supplier;
	}

	public void delete(Supplier entity) {
		supplierImpl.openCurrentSessionwithTransaction();
		supplierImpl.delete(entity);
		supplierImpl.closeCurrentSessionwithTransaction();
	}

	public List<Supplier> findAll() {
		supplierImpl.openCurrentSession();
		List<Supplier> Suppliers = supplierImpl.findAll();
		supplierImpl.closeCurrentSession();
		return Suppliers;
	}

	public void deleteAll() {
		supplierImpl.openCurrentSessionwithTransaction();
		supplierImpl.deleteAll();
		supplierImpl.closeCurrentSessionwithTransaction();
	}

	public SupplierImpl getsupplierImpl() {
		return supplierImpl;
	}


}
