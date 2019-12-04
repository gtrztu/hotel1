package reservation.entity;




import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_rezervacion")
	private int id_rezervacion;
	@Column(name="datebegin")
	private LocalDate datebegin;
	@Column(name="dateend")
	private LocalDate dateend;
	@Column(name="client_id_client")
	private int client_id_client;
	@Column(name="hotelservices_id_service")
	private int hotelservices_id_service;
	@Column(name="typepaket_id_typepaket")
	private int typepaket_id_typepaket;
	@Column(name="login_id_log")
	private int login_id_log;
	
	public Reservation() {
		
	}

	public Reservation(LocalDate datebegin, LocalDate dateend, int client_id_client, int hotelservices_id_service,
			int typepaket_id_typepaket, int login_id_log) {
		this.datebegin = datebegin;
		this.dateend = dateend;
		this.client_id_client = client_id_client;
		this.hotelservices_id_service = hotelservices_id_service;
		this.typepaket_id_typepaket = typepaket_id_typepaket;
		this.login_id_log = login_id_log;
	}

	public int getId_rezervacion() {
		return id_rezervacion;
	}

	public void setId_rezervacion(int id_rezervacion) {
		this.id_rezervacion = id_rezervacion;
	}

	public LocalDate getDatebegin() {
		return datebegin;
	}

	public void setDatebegin(LocalDate datebegin) {
		this.datebegin = datebegin;
	}

	public LocalDate getDateend() {
		return dateend;
	}

	public void setDateend(LocalDate dateend) {
		this.dateend = dateend;
	}

	public int getClient_id_client() {
		return client_id_client;
	}

	public void setClient_id_client(int client_id_client) {
		this.client_id_client = client_id_client;
	}

	public int getHotelservices_id_service() {
		return hotelservices_id_service;
	}

	public void setHotelservices_id_service(int hotelservices_id_service) {
		this.hotelservices_id_service = hotelservices_id_service;
	}

	public int getTypepaket_id_typepaket() {
		return typepaket_id_typepaket;
	}

	public void setTypepaket_id_typepaket(int typepaket_id_typepaket) {
		this.typepaket_id_typepaket = typepaket_id_typepaket;
	}

	public int getLogin_id_log() {
		return login_id_log;
	}

	public void setLogin_id_log(int login_id_log) {
		this.login_id_log = login_id_log;
	}

	@Override
	public String toString() {
		return "Reservation [id_rezervacion=" + id_rezervacion + ", datebegin=" + datebegin + ", dateend=" + dateend
				+ ", client_id_client=" + client_id_client + ", hotelservices_id_service=" + hotelservices_id_service
				+ ", typepaket_id_typepaket=" + typepaket_id_typepaket + ", login_id_log=" + login_id_log + "]";
	}
	
	
	
	
	
	
	
	
}
