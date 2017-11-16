package entidade;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locacao")


public class Locacao {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="dataLocacao")
	private Date dataLocacao;
	
	@Column(name="dataDevolucao")
	private Date dataDevolucao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
}
