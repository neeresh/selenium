import java.util.Scanner;

public class InitCap {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the String:");
		String sentence = scan.nextLine();

		String[] sentenceArray = new String[sentence.split(" ").length];
		String[] capitalizedFirstWords = new String[sentence.split(" ").length];

		sentenceArray = sentence.split(" ");

		// Example :- Work Hard To Get What You Like
		int count = 0;
		
		for (int i = 0; i < sentenceArray.length; i++) {

			if (sentenceArray[i].charAt(0) > 'A' && sentenceArray[i].charAt(0) < 'Z') {
				count = 0;
				capitalizedFirstWords[i] = sentenceArray[i];

			} else {
				count = 1;
				String firstLetter = sentenceArray[i].substring(0, 1).toUpperCase();
				String afterFirstLetter = sentenceArray[i].substring(1);
				String wholeWord = firstLetter + afterFirstLetter;
				
				capitalizedFirstWords[i] = wholeWord;
			}

		} // end of for-loop
		
		if(count != 0) {
			for (int i=0; i<sentenceArray.length; i++) {
				System.out.print(capitalizedFirstWords[i] + " ");
			}
		}else {
			System.out.println("First character of each word is already in uppercase");
		}

	}

}