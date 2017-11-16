package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dvd")

public class DVD {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="indiomasDublados")
	private String indiomasDublados;
	
	@Column(name="indiomasLegendados")
	private String indiomasLegendados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIndiomasDublados() {
		return indiomasDublados;
	}

	public void setIndiomasDublados(String indiomasDublados) {
		this.indiomasDublados = indiomasDublados;
	}

	public String getIndiomasLegendados() {
		return indiomasLegendados;
	}

	public void setIndiomasLegendados(String indiomasLegendados) {
		this.indiomasLegendados = indiomasLegendados;
	}
	
}
