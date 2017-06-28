

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import Models.Passenger;

public class MainApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("config/hibernate.cgf.xml")
				.addPackage("Models")
				.addAnnotatedClass(Passenger.class)
				.buildSessionFactory();
		
		System.out.println("Please Input Passenger info in one string");
		System.out.println("Format: passenger name - location - destination - gender - age");
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext())
		{
			//Stand by for the next episode of this awesome thing called coding...
			String info = scanner.nextLine();
			String[] infoParts = info.split("-");
			
			if(infoParts.length < 5)
			{
				System.out.println("Data input invalid");
			}
			else
			{
				int age = Integer.parseInt(infoParts[4]);
				Passenger passenger = fetchPassengerFromUser(infoParts[0], infoParts[1], infoParts[2], infoParts[3],age);
				passenger.savePassengerToDB(factory.openSession());
				
				if(passenger.getID() != 0)
				{
					System.out.println("Passenger successfully saved");
				}
				
			}
		}
		
	}
	
	private static Passenger fetchPassengerFromUser(String passengerName, String location, String destination, String gender, int age)
	{
		int genderID = 0;
		if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m"))
		{
			genderID = 1;
		}
		else
			genderID = 2;
		
		Passenger passenger = new Passenger();
		passenger.setPassengerName(passengerName);
		passenger.setAge(age);
		passenger.setDestination(destination);
		passenger.setGender(genderID);
		passenger.setLocation(location);
		return passenger;
	}

}
