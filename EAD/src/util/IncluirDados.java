package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.ClienteDAO;
import DAO.ComentarioDAO;
import DAO.FilmeDAO;
import DAO.LocacaoDAO;
import DAO.UnidadeDAO;
import DAO.VHSDAO;
import entidade.Cliente;
import entidade.Comentario;
import entidade.Filme;
import entidade.Locacao;
import entidade.Unidade;
import entidade.VHS;

public class IncluirDados {

	
	public static void main(String[] args) {

		int opcao = 0;
		/*StringBuilder sb = new StringBuilder();
		StringBuilder resultado = new StringBuilder();*/
		ClienteDAO clienteDao = new ClienteDAO();
		ComentarioDAO comentarioDao = new ComentarioDAO();
		FilmeDAO filmeDao = new FilmeDAO();
		LocacaoDAO locacaoDao = new LocacaoDAO();
		UnidadeDAO unidadeDao = new UnidadeDAO();
		VHSDAO vshDao = new VHSDAO();
		
		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Menu " + "\n" + 
					"1 - Incluir Cliente" + "\n" + 
					"2 - Incluir Comentario" + "\n" +
					"3 - Incluir Filme" + "\n" +
					"4 - Locacao" + "\n" +
					"5 - Unidade" + "\n" +
					"6 - VHS" + "\n" +
					"7 - Sair"));

			switch (opcao) {

			case 1:
				Cliente a = new Cliente();
				a.setLogin(JOptionPane.showInputDialog("Digite o Login:"));
				a.setCpf(JOptionPane.showInputDialog("Digite o CPF:"));
				a.setNome(JOptionPane.showInputDialog("Digite o Nome:"));
				clienteDao.incluir(a);
				break;

			case 2:
				Comentario b = new Comentario();
				b.setAvaliacao(Double.parseDouble(JOptionPane.showInputDialog("Digite sua Avaliação")));
				b.setConteudo(JOptionPane.showInputDialog("Digite o Conteudo"));
				comentarioDao.incluir(b);
				break;
			
			case 3:
				Filme c = new Filme();
				c.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código")));
				c.setNome(JOptionPane.showInputDialog("Digite o Nome do Filme"));
				filmeDao.incluir(c);
				break;
			
			case 4:
				Locacao d = new Locacao();
				d.setDataLocacao((java.sql.Date) DataUtil.parseDate(JOptionPane.showInputDialog("Digite a Data de Locação")));
				d.setDataDevolucao((java.sql.Date) DataUtil.parseDate(JOptionPane.showInputDialog("Digite a Data de Devolução")));
				locacaoDao.incluir(d);
				break;
				
			case 5: 
				Unidade e = new Unidade();
				e.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código da Unidade")));
				unidadeDao.incluir(e);
				break;
			
			case 6:
				VHS f = new VHS();
				f.setDublado(Integer.parseInt(JOptionPane.showInputDialog("Digite a Data de Locação")));
				vshDao.incluir(f);
				break;
			
			default:
				break;
			}
		} while (opcao != 7);
	}
}
