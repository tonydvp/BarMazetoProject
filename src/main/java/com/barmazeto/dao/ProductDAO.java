package com.barmazeto.dao;

import com.barmazeto.entity.product.Product;
import com.barmazeto.entity.product.ProductType;
import com.barmazeto.exceptions.DAOException;
import com.barmazeto.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceContext;

public class ProductDAO {
	@PersistenceContext
	private SessionFactory sessionFactory;

	public ProductDAO() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Product product = new Product("Shumensko", 1.25, ProductType.BEER);
		session.save(product);
		session.getTransaction().commit();
	}
	
	public int addProduct(Product product) throws DAOException {
		int id = 0;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			id = (int) sessionFactory.getCurrentSession().save(product);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Product can not be written to database!", e);
		}
		return id;
	}

	public void deleteProduct(Product product) throws DAOException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().delete(product);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Product can not be read from database!", e);
		}
	}

	public Product getProductById(int producttId) throws DAOException {
		Product account = null;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			account = (Product) sessionFactory.getCurrentSession().get(Product.class, producttId);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Account can not be read from database!", e);
		}
		return account;
	}

//	public Collection<Product> getAllBooks() {
//		Query query = sessionFactory.createQuery("SELECT e FROM Employee e WHERE e.name = :name ");
//		query.setParameter("name", name);
//
//		List<Employee> results = query.getResultList();
//        return sessionFactory.createNamedQuery("getAllBooks", Product.class).getResultList();
//    }

	
}
