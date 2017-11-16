package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Comentario")

public class Comentario {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="conteudo")
	private String conteudo;
	
	@Column(name="avaliacao")
	private Double avaliacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}
		
}
