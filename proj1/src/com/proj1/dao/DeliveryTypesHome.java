package com.proj1.dao;
// Generated Nov 26, 2015 7:29:16 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proj1.model.DeliveryTypes;

/**
 * Home object for domain model class DeliveryTypes.
 * @see com.proj1.model.DeliveryTypes
 * @author Hibernate Tools
 */

public class DeliveryTypesHome {

	private static final Log log = LogFactory.getLog(DeliveryTypesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DeliveryTypes transientInstance) {
		log.debug("persisting DeliveryTypes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DeliveryTypes persistentInstance) {
		log.debug("removing DeliveryTypes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DeliveryTypes merge(DeliveryTypes detachedInstance) {
		log.debug("merging DeliveryTypes instance");
		try {
			DeliveryTypes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeliveryTypes findById(Integer id) {
		log.debug("getting DeliveryTypes instance with id: " + id);
		try {
			DeliveryTypes instance = entityManager.find(DeliveryTypes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
