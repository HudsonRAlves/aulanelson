package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Locacao;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class LocacaoDAO extends GenericDaoImpl<Locacao> {

	public LocacaoDAO() {
		super(Locacao.class);
	}

	public static List<Locacao> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<Locacao> lista = s.createQuery("select cat from Aluno cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Locacao recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		Locacao meta = (Locacao) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<Locacao> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<Locacao> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}
