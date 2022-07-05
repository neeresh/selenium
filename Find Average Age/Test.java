import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {

	double calculateAverage(int[] age) {
		double sum = 0.0;

		for (int i = 0; i < age.length; i++) {
			sum += age[i];
		}

		double averageAge = sum / age.length;

		return averageAge;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter total no.of employees:");
		int totalNoOfEmployees = scan.nextInt();

		if (totalNoOfEmployees <= 1) {
			System.out.println("Please enter a valid employee count");
			System.exit(0);

		}

		System.out.println("Enter the age for " + totalNoOfEmployees + " employees:");

		int[] agesOfEmployees = new int[totalNoOfEmployees];

		for (int i = 0; i < totalNoOfEmployees; i++) {
			int age = scan.nextInt();

			if (age >= 28 && age <= 40) {
				agesOfEmployees[i] = age;
			} else {
				System.out.println("Invalid age encountered!");
				System.exit(0);
			}

		} // end of for-loop

		Test test = new Test();

		double calculateAverage = test.calculateAverage(agesOfEmployees);

		DecimalFormat decimalformat = new DecimalFormat("0.00");

		System.out.println("The average age is " + decimalformat.format(calculateAverage));

	}

}
