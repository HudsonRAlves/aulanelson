package DAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class GenericDaoImpl<T> implements GenericDao<T> {

	private Class persistenceClass;

	public GenericDaoImpl(Class c) {
		this.persistenceClass = c;
	}

	public T recuperar(Serializable id) {
		Session session = HibernateUtil.getSession();
		T o = (T) session.get(persistenceClass, id);
		session.close();
		return o;
	}

	public void atualizar(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(obj);
		t.commit();
		session.refresh(obj);
		session.close();
	}

	public Serializable incluir(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		Serializable id = session.save(obj);
		t.commit();
		session.flush();
		session.refresh(obj);
		session.close();
		return id;
	}

	public List<T> recuperarTodos() {
		Session session = HibernateUtil.getSession();		
		List<T> results = session.createQuery(
				"FROM " + persistenceClass.getName()).list();
		session.close();
		return results;
	}
	
	public void excluir(T obj) {
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		session.delete(obj);
		t.commit();
		session.close();
	}

}
