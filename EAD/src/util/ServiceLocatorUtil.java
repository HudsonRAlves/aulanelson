package util;

import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ServiceLocatorUtil {

	/**
	 * Atributo static que armazerá a instância da classe
	 */
	private static ServiceLocatorUtil instance = null;

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Map que mantém organizados as Sessions já configuradas
	 */
	private HashMap cache = null;

	/**
	 * Construtor privado,garantindo que nenhuma entidade exterior conseguirá
	 * criar uma nova instância
	 * 
	 * @throws NamingException
	 */
	private ServiceLocatorUtil() throws NamingException {
		cache = new HashMap();
	}

	/**
	 * Utilizado para recuperar a instância da classe ServiceLocatorDAO na
	 * memória
	 * 
	 * @return ServiceLocatorDAO
	 * @throws NamingException
	 */
	public static ServiceLocatorUtil getInstance() throws NamingException {
		if (instance == null) {
			instance = new ServiceLocatorUtil();
		}
		return instance;
	}

	public org.hibernate.Session getHibernateSession(String fileName) {
		org.hibernate.cfg.Configuration cfg;
		org.hibernate.SessionFactory f = null;
		if (!cache.containsKey(fileName)) {
			cfg = new AnnotationConfiguration();
			cfg.configure(fileName);
			f = cfg.buildSessionFactory();
			cache.put(fileName, f);
		}
		f = (SessionFactory) cache.get(fileName);

		Session s = null;

		try {

			s = f.getCurrentSession();
		} catch (HibernateException e) {
			s = f.openSession();
		}

		try {
			if (!s.isOpen()) {
				// Se a sessao corrente está fechada, retorna uma nova
				s = f.openSession();
			} else {
				// Se a sessao corrente está aberta mas a conection fechada,
				// retorna
				// uma nova conexao
				if (s.connection().isClosed()) {
					s.close();
					s = f.openSession();
				}
			}
			/*
			 * if (!s.isOpen()||s.connection().isClosed()){ s.close(); s =
			 * f.openSession(); }
			 */
		} catch (HibernateException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
		} catch (SQLException ex) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ ex.getMessage(), ex);
		}
		return s;
	}

	/**
	 * Retorna uma sessão hibernate associada com uma transação atual, dessa
	 * forma utilizamos o padrão conhecido como session-per-request ao invés do
	 * anti-pattern session-per-operation que abre e fecha uma Hibernate Session
	 * para cada operação. O arquivo de configurações utilizado será o
	 * hibernate.cfg.xml, que deverá estar localizado no classpath da aplicação
	 * 
	 * @return Uma sessão Hibernate
	 * 
	 */
	public org.hibernate.Session getHibernateSession() {
		return getHibernateSession("/hibernate.cfg.xml");
	}

	/**
	 * Abre uma sessão hibernate
	 * 
	 * @return Uma sessão Hibernate
	 * @param Nome
	 *            do arquivo de confirurações do Hibernate
	 */
	public org.hibernate.Session openHibernateSession(String fileName) {
		org.hibernate.cfg.Configuration cfg;
		org.hibernate.SessionFactory f = null;
		if (!cache.containsKey(fileName)) {
			cfg = new org.hibernate.cfg.Configuration();
			cfg.configure(fileName);
			f = cfg.buildSessionFactory();
			cache.put(fileName, f);
		}
		f = (SessionFactory) cache.get(fileName);
		Session s = f.openSession();
		try {
			if (!s.isOpen() || s.connection().isClosed()) {
				s.close();
				s = f.openSession();
			}
		} catch (HibernateException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("Erro ao recuperar sessao do Hibernate: "
					+ e.getMessage(), e);
		}
		return s;
	}

	/**
	 * Abre uma sessão hibernate
	 * 
	 * @return Uma sessão Hibernate
	 * @param Nome
	 *            do arquivo de confirurações do Hibernate
	 */
	public org.hibernate.Session openHibernateSession() {
		return openHibernateSession("/hibernate.cfg.xml");
	}

}