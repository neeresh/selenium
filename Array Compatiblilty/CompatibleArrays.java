import java.util.Scanner;

public class CompatibleArrays {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the size for First array:");
		int firstArraySize = scan.nextInt();
		int[] firstArray = null;

		if (firstArraySize > 0) {
			firstArray = new int[firstArraySize];
		} else {
			System.out.println("Invalid array size");
			System.exit(0);
		}

		System.out.println("Enter the elements for First array:");

		for (int i = 0; i < firstArraySize; i++) {
			firstArray[i] = scan.nextInt();
		}

		System.out.println("Enter the size for Second array:");
		int secondArraySize = scan.nextInt();
		int[] secondArray = null;

		if (secondArraySize > 0) {
			secondArray = new int[secondArraySize];
		} else {
			System.out.println("Invalid array size");
			System.exit(0);
		}

		System.out.println("Enter the elements for Second array:");

		for (int i = 0; i < secondArraySize; i++) {
			secondArray[i] = scan.nextInt();
		}

		if (firstArraySize == secondArraySize) {

			boolean flag = false;

			for (int i = 0; i < firstArraySize; i++) {

				if (firstArray[i] >= secondArray[i]) {
					flag = true;
					continue;
				} else {
					System.out.println("Arrays are not compatible");
					System.exit(0);
				}

			} // end of for-loop

			if (flag) {
				System.out.println("Arrays are compatible");
			}

		} else {
			System.out.println("Arrays are not compatible");
		}

	}

}
