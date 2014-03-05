package com.freeworld.share.bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class BaseBean {
	@PersistenceContext
	protected EntityManager em;
}
