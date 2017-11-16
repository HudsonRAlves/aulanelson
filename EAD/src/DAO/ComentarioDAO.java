package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Comentario;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class ComentarioDAO extends GenericDaoImpl<Comentario> {

	public ComentarioDAO() {
		super(Comentario.class);
	}

	public static List<Comentario> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<Comentario> lista = s.createQuery("select cat from Comentario cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Comentario recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		Comentario meta = (Comentario) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Comentario> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<Comentario> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
