package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.Log;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	@Column(name = "passengerName")
	private String passengerName;
	
	@Column(name  ="location")
	private String location;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "age")
	private int age;
	
	public Passenger(){}
	
	
	
	public Integer getID() {
		return ID;
	}



	public void setID(Integer iD) {
		ID = iD;
	}



	public String getPassengerName() {
		return passengerName;
	}



	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public int getGender() {
		return gender;
	}



	public void setGender(int gender) {
		this.gender = gender;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	/**
	 * Method for the model to persist itself
	 * @param session
	 * @return
	 */
	private int persistPassenger(Session session)
	{
		
		try
		{
			session.beginTransaction();
			ID = (Integer)session.save(this);
			session.getTransaction().commit();			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return 0;
	}
	
	/**
	 * Access method for DB persist method
	 * @param session
	 * @return
	 */
	public int savePassengerToDB(Session session)
	{
				
		return this.persistPassenger(session);
	}
	
	public boolean removePassengerFromDB(Session session)
	{
		return this.deletePassenger(session);
	}
	
	public boolean updatePassengerInDB(Session session)
	{
		return this.updatePassenger(session);
	}
	
	@Override
	public String toString()
	{
		return passengerName + "--" + location + "--" + destination + "--" + gender + "--" + age;
	}
	
	/**
	 * private DB delete method returning boolean based on returned results
	 * @param session
	 * @return
	 */
	private boolean deletePassenger(Session session)
	{
		
		try
		{
			session.beginTransaction();
			session.delete(this);
			session.getTransaction().commit();		
			session.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;

	}
	
	/**
	 * private DB update method returning boolean based on returned results
	 * @param session
	 * @return
	 */
	private boolean updatePassenger(Session session)
	{
		
		try
		{
			session.beginTransaction();
			session.update(this);
			session.getTransaction().commit();		
			session.close();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;

	}
	
}
