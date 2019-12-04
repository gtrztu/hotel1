package hotelservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotelservices")
public class Hotelservice {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_service")
	private int id_service;
	
	@Column(name="typeservice")
	private String typeservice;

	public Hotelservice() {
		
	}

	public Hotelservice(String typeservice) {
		this.typeservice = typeservice;
	}

	public int getId_service() {
		return id_service;
	}

	public void setId_service(int id_service) {
		this.id_service = id_service;
	}

	public String getTypeservice() {
		return typeservice;
	}

	public void setTypeservice(String typeservice) {
		this.typeservice = typeservice;
	}

	@Override
	public String toString() {
		return "Hotelservice [id_service=" + id_service + ", typeservice=" + typeservice + "]";
	}
	
	
	
}
