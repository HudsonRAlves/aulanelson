package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.DVD;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class DVDDAO extends GenericDaoImpl<DVD> {

	public DVDDAO() {
		super(DVD.class);
	}

	public static List<DVD> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<DVD> lista = s.createQuery("select cat from Aluno cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public DVD recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		DVD meta = (DVD) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<DVD> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<DVD> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
