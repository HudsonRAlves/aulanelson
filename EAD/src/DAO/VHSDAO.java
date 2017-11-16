package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidade.VHS;
import util.HibernateUtil;
import util.ServiceLocatorUtil;


public class VHSDAO extends GenericDaoImpl<VHS> {

	public VHSDAO() {
		super(VHS.class);
	}

	public static List<VHS> listar() {
		Session s;
		try {
			s = ServiceLocatorUtil.getInstance().getHibernateSession();
			List<VHS> lista = s.createQuery("select cat from Aluno cat").list();
			s.close();

			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public VHS recuperaAluno(int anoAadp) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.anoAadp = :anoAadp");

		query.setParameter("anoAadp", anoAadp);
		VHS meta = (VHS) query.setMaxResults(1).uniqueResult();
		session.close();
		try {
			return meta;
		} catch (Exception e) {
			return null;
		}

	}

	public List<VHS> recuperaCandidato(int Aluno) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Aluno a WHERE a.Aluno = :Aluno");

		query.setParameter("Aluno", Aluno);
		List<VHS> resultados = query.list();
		session.close();
		try {
			return resultados;
		} catch (Exception e) {
			return null;
		}
	}

}

