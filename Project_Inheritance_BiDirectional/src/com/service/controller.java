package com.service;

import org.hibernate.Session;

public interface controller {

	public void lcreate(Session session);
	public void lread(Session session);
	public void lupdate(Session session);
	public void ldelete(Session session);
	public void lgetSingleData(Session session);
	public void dcreate(Session session);
	
	public void mcreate(Session session);
	public void mread(Session session);
	public void mupdate(Session session);
	public void mdelete(Session session);
	public void mgetSingleData(Session session);
	public void ddelete(Session session);
}
