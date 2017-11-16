package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Filme;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class FilmeDAO extends GenericDaoImpl<Filme> {

	public FilmeDAO() {
		super(Filme.class);
	}

	public static List<Filme> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<Filme> lista = s.createQuery("select cat from Aluno cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Filme recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		Filme meta = (Filme) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Filme> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<Filme> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
