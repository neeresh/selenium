import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	
	public static double FuelConsumptionInMiles(int noOfLiters, double distance) {
		return (noOfLiters/distance) * 100;
		
	}
	
	public static double FuelConsumptionInGallons(int noOfLiters, double distance) {
		double gallons = noOfLiters * 0.2642;
		double miles = distance * 0.6214;
		
		return (miles/gallons);
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DecimalFormat decimalformat = new DecimalFormat("0.00");
		
		System.out.println("Enter the no of liters to fill the tank");
		int noOfLiters = scan.nextInt();
		scan.nextLine();
		
		if(noOfLiters <= 0) {
			System.out.println(noOfLiters + " is an Invalid Input");
			System.exit(0);
			
		}
		
		System.out.println("Enter the distance covered");
		double distance = scan.nextDouble();
		
		if(distance <= 0) {
			System.out.println((int)distance + " is an Invalid Input");
			System.exit(0);
			
		}
		
		System.out.println("Liters/100KM\n" + decimalformat.format(FuelConsumptionInMiles(noOfLiters, distance)));
		System.out.println("Miles/gallons\n" + decimalformat.format(FuelConsumptionInGallons(noOfLiters, distance)));
		
	}
	
	
}