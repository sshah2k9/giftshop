package com.proj1.dao;
// Generated Nov 26, 2015 7:29:16 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proj1.model.DeliveryDetails;

/**
 * Home object for domain model class DeliveryDetails.
 * @see com.proj1.model.DeliveryDetails
 * @author Hibernate Tools
 */

public class DeliveryDetailsHome {

	private static final Log log = LogFactory.getLog(DeliveryDetailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DeliveryDetails transientInstance) {
		log.debug("persisting DeliveryDetails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DeliveryDetails persistentInstance) {
		log.debug("removing DeliveryDetails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DeliveryDetails merge(DeliveryDetails detachedInstance) {
		log.debug("merging DeliveryDetails instance");
		try {
			DeliveryDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeliveryDetails findById(Integer id) {
		log.debug("getting DeliveryDetails instance with id: " + id);
		try {
			DeliveryDetails instance = entityManager.find(DeliveryDetails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
