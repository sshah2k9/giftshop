package com.proj1.dao;
// Generated Nov 14, 2015 7:53:22 PM by Hibernate Tools 4.3.1.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proj1.model.Address;

/**
 * Home object for domain model class Address.
 * @see com.proj1.model.Address
 * @author Hibernate Tools
 */

public class AddressHome {

	private static final Log log = LogFactory.getLog(AddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Address transientInstance) {
		log.debug("persisting Address instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Address persistentInstance) {
		log.debug("removing Address instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Address findById(Integer id) {
		log.debug("getting Address instance with id: " + id);
		try {
			Address instance = entityManager.find(Address.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
