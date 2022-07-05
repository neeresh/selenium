import java.util.Scanner;

public class FirstOccurence {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the string:");
		String sentence = scan.nextLine();

		System.out.println("Enter the character to be searched:");
		Character character = scan.next().charAt(0);

		System.out.println("Enter the character to replace:");
		Character replace = scan.next().charAt(0);

		if (!sentence.contains(String.valueOf(character))) {
			System.out.println("character not found");
			System.exit(0);

		}

		char[] characterArray = sentence.toCharArray();

		for (int i = 0; i < characterArray.length; i++) {
			Character equate = characterArray[i];
			if (character.equals(equate)) {
				characterArray[i] = replace;
				break;
			}
		} // end of foor-loop

		for (int i = 0; i < characterArray.length; i++) {
			System.out.print(characterArray[i]);
		}

	}

}
