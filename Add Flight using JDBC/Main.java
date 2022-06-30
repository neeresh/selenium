import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		FlightManagementSystem flightmanagementsystem = new FlightManagementSystem();
		
		int flightId = scan.nextInt();
		scan.nextLine();
		
		String source = scan.nextLine();
		String destination = scan.nextLine();
		int noOfSeats = scan.nextInt();
		double flighFare = scan.nextDouble();
		
		Flight flight = new Flight(flightId, source, destination, noOfSeats, flighFare);
		
		
		if(flightmanagementsystem.addFlight(flight)) {
			System.out.println("Flight Details added successfully");
		}else {
			System.out.println("Addition not done");
		}
		
	}
}