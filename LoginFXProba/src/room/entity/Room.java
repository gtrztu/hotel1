package room.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_room")
	private int id_room;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="roomnumber")
	private String roomnumber;

	public Room() {
		
	}

	public Room(Boolean status, String roomnumber) {
		this.status = status;
		this.roomnumber = roomnumber;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	@Override
	public String toString() {
		return "Room [id_room=" + id_room + ", status=" + status + ", roomnumber=" + roomnumber + "]";
	}

	
	
	
	
}
