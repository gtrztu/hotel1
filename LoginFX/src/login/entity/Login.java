package login.entity;

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
	@Column(name="id_log")
	private int id_log;
	
	@Column(name="Fname")
	private String fname;
	
	@Column(name="Lname")
	private String lname;
	
	@Column(name="passwordl")
	private String password;
	
	@Column(name="numberChek")
	private int number1;
	
	@Column(name="Hotel_id_hotel")
	private int hotel_id_hotel;
	
	public Login() {
		
	}



	public Login(String fname, String lname, String password, int number1, int hotel_id_hotel) {
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.number1 = number1;
		this.hotel_id_hotel = hotel_id_hotel;
	}



	public int getId_log() {
		return id_log;
	}

	public void setId_log(int id_log) {
		this.id_log = id_log;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumber() {
		return number1;
	}

	public void setNumber(int number) {
		this.number1 = number;
	}

	public int getHotel_id_hotel() {
		return hotel_id_hotel;
	}

	public void setHotel_id_hotel(int hotel_id_hotel) {
		this.hotel_id_hotel = hotel_id_hotel;
	}

	@Override
	public String toString() {
		return "Login [id_log=" + id_log + ", fname=" + fname + ", lname=" + lname + ", password=" + password
				+ ", number=" + number1 + ", hotel_id_hotel=" + hotel_id_hotel + "]";
	}



	
	
	
	
	
	
}
