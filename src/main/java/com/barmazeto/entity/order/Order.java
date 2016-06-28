package com.barmazeto.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order")
@NamedQueries({ @NamedQuery(name = "getAllOrders", query = "SELECT o FROM Order o") })
public class Order {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrder;

	@Column
	private Date timeStarted;
	@Column
	private Date timeFinished;
	@Column
	private Integer idBarman;
	@Column
	private Integer idWaiter;

	public Order(Date timeStarted, Date timeFinished, Integer idBarman, Integer idWaiter) {
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
		this.idBarman = idBarman;
		this.idWaiter = idWaiter;
	}

	public Order(Date timeStarted, Integer idBarman, Integer idWaiter) {
		this.timeStarted = timeStarted;
		this.idBarman = idBarman;
		this.idWaiter = idWaiter;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Date getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(Date timeStarted) {
		this.timeStarted = timeStarted;
	}

	public Date getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(Date timeFinished) {
		this.timeFinished = timeFinished;
	}

	public Integer getIdBarman() {
		return idBarman;
	}

	public void setIdBarman(Integer idBarman) {
		this.idBarman = idBarman;
	}

	public Integer getIdWaiter() {
		return idWaiter;
	}

	public void setIdWaiter(Integer idWaiter) {
		this.idWaiter = idWaiter;
	}
}
