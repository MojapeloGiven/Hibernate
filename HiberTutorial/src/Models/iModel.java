package Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;

public abstract class iModel {


	protected Integer ID;
	
	/**
	 * Method for the model to persist itself
	 * @param session
	 * @return
	 */
	protected int persistToDB(Session session)
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
	 * private DB delete method returning boolean based on returned results
	 * @param session
	 * @return
	 */
	protected boolean deleteFromDB(Session session)
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
	private boolean updateInDB(Session session)
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
