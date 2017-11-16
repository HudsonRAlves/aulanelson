package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Livro;
import util.HibernateUtil;
import util.ServiceLocatorUtil;

public class LivroDAO extends GenericDaoImpl<Livro> {

	public LivroDAO() {
		super(Livro.class);
	}

	public static List<Livro> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<Livro> lista = s.createQuery("select cat from Livro cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Livro recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		Livro meta = (Livro) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Livro> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<Livro> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
