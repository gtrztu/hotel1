package client.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_client")
	private int id_client;
	@Column(name="firstname")
	private String FirstName;
	@Column(name="laastname")
	private String LastName;
	@Column(name="addres")
	private String Addres;
	@Column(name="phone")
	private String Phone;
	@Column(name="age")
	private int age;
	@Column(name="reiting")
	private int reiting;
	@Column(name="hotel_id_hotel")
	private int hotel_id_hotel;
	
	public Client() {
		
	}

	public Client(String firstName, String laastName, String addres, String phone, int age, int reiting,
			int hotel_id_hotel) {
		
		FirstName = firstName;
		LastName = laastName;
		Addres = addres;
		Phone = phone;
		this.age = age;
		this.reiting = reiting;
		this.hotel_id_hotel = hotel_id_hotel;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String laastName) {
		LastName = laastName;
	}

	public String getAddres() {
		return Addres;
	}

	public void setAddres(String addres) {
		Addres = addres;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getReiting() {
		return reiting;
	}

	public void setReiting(int reiting) {
		this.reiting = reiting;
	}

	public int getHotel_id_hotel() {
		return hotel_id_hotel;
	}

	public void setHotel_id_hotel(int hotel_id_hotel) {
		this.hotel_id_hotel = hotel_id_hotel;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Addres="
				+ Addres + ", Phone=" + Phone + ", age=" + age + ", reiting=" + reiting + ", hotel_id_hotel="
				+ hotel_id_hotel + "]";
	}
	
	
	
	
}
