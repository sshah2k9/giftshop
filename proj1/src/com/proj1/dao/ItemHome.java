package com.proj1.dao;
// Generated Nov 26, 2015 7:29:16 PM by Hibernate Tools 4.3.1.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proj1.listeners.EMF;
import com.proj1.model.Item;

/**
 * Home object for domain model class Item.
 * 
 * @see com.proj1.model.Item
 * @author Hibernate Tools
 */

public class ItemHome {

	private static final Log log = LogFactory.getLog(ItemHome.class);

	private EntityManager entityManager;
	
	public ItemHome(){
		entityManager = EMF.createEntityManager();
	}
	
	public ItemHome(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public void persist(Item transientInstance) {
		log.debug("persisting Item instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Item persistentInstance) {
		log.debug("removing Item instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Item merge(Item detachedInstance) {
		log.debug("merging Item instance");
		try {
			Item result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Item findById(Integer id) {
		log.debug("getting Item instance with id: " + id);
		try {
			Item instance = entityManager.find(Item.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Item> findByCategoryId(Integer id) {
		log.debug("getting Item instance with category id: " + id);
		try {
			Query query = entityManager.createNamedQuery("Item.byCategoryId");
			query.setParameter(1, id);
			@SuppressWarnings("unchecked")
			List<Item> items = (List<Item>) query.getResultList();
			log.debug("get successful");
			return items;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
