package com.niit.ecomm_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.niit.ecomm_backend.dao.CategoryDao;
import com.niit.ecomm_backend.dao.Dao;
import com.niit.ecomm_backend.impl.CategoryImpl;
import com.niit.ecomm_backend.model.Category;

@Service
public class CategoryService implements Dao<Category>{
	@Autowired
	private CategoryImpl categoryImpl;

/*	public CategoryService() {
		categoryImpl = new CategoryImpl();
	}*/

	public void persist(Category entity) {
		categoryImpl.openCurrentSessionwithTransaction();
		categoryImpl.persist(entity);
		categoryImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Category entity) {
		categoryImpl.openCurrentSessionwithTransaction();
		categoryImpl.update(entity);
		categoryImpl.closeCurrentSessionwithTransaction();
	}

	public Category findById(int id) {
		categoryImpl.openCurrentSession();
		Category Category = categoryImpl.findById(id);
		categoryImpl.closeCurrentSession();
		return Category;
	}

	public void delete(Category entity) {
		categoryImpl.openCurrentSessionwithTransaction();
		categoryImpl.delete(entity);
		categoryImpl.closeCurrentSessionwithTransaction();
	}

	public List<Category> findAll() {
		categoryImpl.openCurrentSession();
		List<Category> Categorys = categoryImpl.findAll();
		categoryImpl.closeCurrentSession();
		return Categorys;
	}

	public void deleteAll() {
		categoryImpl.openCurrentSessionwithTransaction();
		categoryImpl.deleteAll();
		categoryImpl.closeCurrentSessionwithTransaction();
	}

	public CategoryImpl getcategoryImpl() {
		return categoryImpl;
	}


}
