package hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_login")
	private int id_login;
	@Column(name="fname")
	private String fname;
	@Column(name="lname")
	private String lname;
	@Column(name="password")
	private int password;
	@Column(name="number")
	private int number;
	@Column(name="hotel_id_hotel")
	private int hotel_id_hotel;
	
	public Login() {
		
	}



	public Login(String fname, String lname, int password, int number, int hotel_id_hotel) {
	
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.number = number;
		this.hotel_id_hotel = hotel_id_hotel;
	}


	public int getId_login() {
		return id_login;
	}



	public void setId_login(int id_login) {
		this.id_login = id_login;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public int getPassword() {
		return password;
	}



	public void setPassword(int password) {
		this.password = password;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public int getHotel_id_hotel() {
		return hotel_id_hotel;
	}



	public void setHotel_id_hotel(int hotel_id_hotel) {
		this.hotel_id_hotel = hotel_id_hotel;
	}



	@Override
	public String toString() {
		return "Login [id_login=" + id_login + ", fname=" + fname + ", lname=" + lname + ", password=" + password
				+ ", number=" + number + ", hotel_id_hotel=" + hotel_id_hotel + "]";
	}
	
	
	
	
	
	
}
