package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "bus")
public class Bus {

	
	@Column(name = "busRegistration")
	private String busRegistration;
	
	@Column(name = "busMaker")
	private String busMaker;
	
	@Column(name = "seatCount")
	private int seatCount;
	
	
	
	
}
