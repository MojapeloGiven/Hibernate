package Models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class PassengerList {

	List<Passenger> passengersList;
	
	public PassengerList()
	{
		passengersList = new ArrayList<Passenger>();
	}
	
	private List<Passenger> fetchPassengersFromDB(Session session)
	{
		List<Passenger> localPassengersList;
		
		try
		{
			session.beginTransaction();
			localPassengersList = session.createQuery("FROM passenger").list();
			session.getTransaction().commit();		
			session.close();
			return localPassengersList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}
	
}
