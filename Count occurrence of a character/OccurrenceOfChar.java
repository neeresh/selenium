import java.util.Scanner;

public class OccurrenceOfChar {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a word:");
		String word = scan.nextLine();

		char[] wordChecker = word.toCharArray();

		for (int i = 0; i < wordChecker.length; i++) {
			if (! ( (wordChecker[i] >= 'a' && wordChecker[i] <= 'z') || (wordChecker[i] >= 'A' && wordChecker[i] <= 'Z') )) {
				System.out.println("Not a valid string");
				System.exit(0);
			}
		} // end of for-loop

		System.out.println("Enter the character:");
		char character = scan.nextLine().charAt(0);

		if (! ( (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') )) {
			System.out.println("Given character is not an alphabet");
			System.exit(0);
		}
		
		int count = 0;
		for(int i=0; i<wordChecker.length; i++) {
			
			if(character == wordChecker[i]) {
				count++;
			}
			
		} // end of for-loop
		
		if(count == 0) {
			System.out.println("The given character '"+ character +"' not present in the given word.");
		}else {
			System.out.println("No of '" + character +"' present in the given word is " + count + ".");
		}
		
		
	}

}