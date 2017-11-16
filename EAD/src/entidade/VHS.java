package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vhs")

public class VHS {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="dublado")
	private int dublado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDublado() {
		return dublado;
	}

	public void setDublado(int dublado) {
		this.dublado = dublado;
	}
	
}
