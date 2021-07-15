package com.ecomm.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.entity.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCategory(Category category) {
		
		try{
			Session session=sessionFactory.getCurrentSession();
			session.save(category);
			return true;
		}
		catch(Exception e){
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.delete(category);	
			return true;
		}
		catch(Exception e){
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public boolean updateCategory(Category category) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(category);
			return true;
		}
		catch(Exception e){
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}

	public List<Category> retrieveCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> categoryList=query.list();
		session.close();
		return categoryList;
	}

	
	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class,categoryId);
		session.close();
		return category;
	}
	
}
