package hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_hotel")
	private int id_hotel;
	@Column(name="name")
	private String Name;
	@Column(name="address")
	private String Address;
	
	
	public Hotel()
	{
		
	}


	public Hotel( String name, String address) {
		Name = name;
		Address = address;
	}


	public int getId_hotel() {
		return id_hotel;
	}


	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	@Override
	public String toString() {
		return "Hotel [id_hotel=" + id_hotel + ", Name=" + Name + ", Address=" + Address + "]";
	}
	
	
}