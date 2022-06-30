import java.util.Scanner;

public class BikeRace {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the distance travelled");
		String distance = scan.nextLine();

		if (Integer.parseInt(distance) < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		if (Integer.parseInt(distance) == 0) {
			System.out.println("Your bonus points is " + distance);
			System.exit(0);
		}

		// 5632 -> 5*3 = 15 ; 6*2 -> 12

		int oddMultiplier = 1;
		int evenMultiplier = 1;

		for (int i = 1; i <= distance.length(); i++) {

			if (i % 2 == 0) {
				// System.out.println("Even");
				char charToString = distance.charAt(i - 1);
				evenMultiplier = evenMultiplier * Integer.parseInt(String.valueOf(charToString));

			} else {
				// System.out.println("Odd");
				char charToString = distance.charAt(i - 1);
				oddMultiplier = oddMultiplier * Integer.parseInt(String.valueOf(charToString));

			}

		} // end of for-loop
		
		if(evenMultiplier == oddMultiplier) {
			System.out.println("Your bonus points is " + evenMultiplier*2);
		
		}else if(evenMultiplier > oddMultiplier) {
			System.out.println("Your bonus points is " + evenMultiplier);
		}else {
			System.out.println("Your bonus points is " + oddMultiplier);
		}
		
		
	}

}