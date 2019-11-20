package recepcionist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Recepcionist")
public class Recepcionist {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_recep")
	private int id_recep;
	
	@Column(name="nFname")
	private String nfname;
	
	@Column(name="nLname")
	private String nlname;
	
	@Column(name="npassword")
	private String npassword;
		
	@Column(name="Hotel_id_hotel")
	private int hotel_id_hotel;

	public Recepcionist() {
		
	}

	public Recepcionist(String nfname, String nlname, String npassword, int hotel_id_hotel) {
		this.nfname = nfname;
		this.nlname = nlname;
		this.npassword = npassword;
		this.hotel_id_hotel = hotel_id_hotel;
	}

	public int getId_recep() {
		return id_recep;
	}

	public void setId_recep(int id_recep) {
		this.id_recep = id_recep;
	}

	public String getNfname() {
		return nfname;
	}

	public void setNfname(String nfname) {
		this.nfname = nfname;
	}

	public String getNlname() {
		return nlname;
	}

	public void setNlname(String nlname) {
		this.nlname = nlname;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	public int getHotel_id_hotel() {
		return hotel_id_hotel;
	}

	public void setHotel_id_hotel(int hotel_id_hotel) {
		this.hotel_id_hotel = hotel_id_hotel;
	}

	@Override
	public String toString() {
		return "Recepcionist [id_recep=" + id_recep + ", nfname=" + nfname + ", nlname=" + nlname + ", npassword="
				+ npassword + ", hotel_id_hotel=" + hotel_id_hotel + "]";
	}

	
	
	
	
	
	
}
