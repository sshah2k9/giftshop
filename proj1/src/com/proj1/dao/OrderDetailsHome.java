package com.proj1.dao;
// Generated Nov 14, 2015 7:53:22 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proj1.model.OrderDetails;

/**
 * Home object for domain model class OrderDetails.
 * @see com.proj1.model.OrderDetails
 * @author Hibernate Tools
 */

public class OrderDetailsHome {

	private static final Log log = LogFactory.getLog(OrderDetailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OrderDetails transientInstance) {
		log.debug("persisting OrderDetails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OrderDetails persistentInstance) {
		log.debug("removing OrderDetails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OrderDetails merge(OrderDetails detachedInstance) {
		log.debug("merging OrderDetails instance");
		try {
			OrderDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrderDetails findById(Integer id) {
		log.debug("getting OrderDetails instance with id: " + id);
		try {
			OrderDetails instance = entityManager.find(OrderDetails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
