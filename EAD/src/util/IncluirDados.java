package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.ClienteDAO;

import entidade.Cliente;


public class IncluirDados {

	
	public static void main(String[] args) {

		int opcao = 0;
		/*StringBuilder sb = new StringBuilder();
		StringBuilder resultado = new StringBuilder();*/
		ClienteDAO clienteDao = new ClienteDAO();
		
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
			
			default:
				break;
			}
		} while (opcao != 7);
	}
}
