package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Unidade;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class UnidadeDAO extends GenericDaoImpl<Unidade> {

	public UnidadeDAO() {
		super(Unidade.class);
	}

	public static List<Unidade> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<Unidade> lista = s.createQuery("select cat from Aluno cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Unidade recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		Unidade meta = (Unidade) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Unidade> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<Unidade> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
