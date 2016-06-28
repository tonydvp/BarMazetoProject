package com.barmazeto.dao;

import com.barmazeto.entity.order.Order;
import com.barmazeto.exceptions.DAOException;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceContext;

public class OrderDAO {
	@PersistenceContext
	private SessionFactory sessionFactory;

	public int addOrder(Order order) throws DAOException {
		int id = 0;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			id = (int) sessionFactory.getCurrentSession().save(order);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException exeption) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Order not added!", exeption);
		}
		return id;
	}

	public void deleteOrder(Order product) throws DAOException {
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().delete(product);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException exception) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Order not found!", exception);
		}
	}

	public Order getOrderById(int orderId) throws DAOException {
		Order o = null;
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			o = (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
			sessionFactory.getCurrentSession().getTransaction().commit();
		} catch (RuntimeException exception) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			throw new DAOException("Order not found!", exception);
		}
		return o;
	}



}
