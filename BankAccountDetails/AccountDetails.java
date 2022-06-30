import java.util.Scanner;

public class AccountDetails {

	Scanner scan = new Scanner(System.in);
	Account account = new Account();

	public Account getAccountDetails() {

		System.out.println("Enter account id:");
		int accountId = scan.nextInt();
		scan.nextLine();

		System.out.println("Enter the account type:");
		String accountType = scan.nextLine();
		
		int balance = 0;
		
		do {
			System.out.println("Enter balance:");
			balance = scan.nextInt();
			scan.nextLine();

			if (balance <= 0) {
				System.out.println("Balance should be positive");
				continue;
			}
			break;
		} while (true);

		account.setAccountId(accountId);
		account.setAccountType(accountType);
		account.setBalance(balance);

		return account;
	}

	public int getWithdrawAmount() {

		int withdraw;

		do {
			System.out.println("Enter the amount to be withdrawn:");
			withdraw = scan.nextInt();
			scan.nextLine();

			if (withdraw <= 0) {
				System.out.println("Amount should be positive");
				continue;
			}

			break;
		} while (true);

		return withdraw;
	}

	public static void main(String[] args) {

		AccountDetails accountdetails = new AccountDetails();

		Account accountDetails2 = accountdetails.getAccountDetails();

		int withdrawAmount = accountdetails.getWithdrawAmount();
		
		accountDetails2.withdraw(withdrawAmount);
		

	}

}
