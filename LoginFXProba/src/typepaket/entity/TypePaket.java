package typepaket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typepaket")
public class TypePaket {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_typepaket")
	private int id_typepaket;
	
	@Column(name="typepaket")
	private String typepaket;

	public TypePaket() {
	}

	public TypePaket(String typepaket) {
		this.typepaket = typepaket;
	}

	public int getId_typepaket() {
		return id_typepaket;
	}

	public void setId_typepaket(int id_typepaket) {
		this.id_typepaket = id_typepaket;
	}

	public String getTypepaket() {
		return typepaket;
	}

	public void setTypepaket(String typepaket) {
		this.typepaket = typepaket;
	}

	@Override
	public String toString() {
		return "TypePaket [id_typepaket=" + id_typepaket + ", typepaket=" + typepaket + "]";
	}
	
	

}
