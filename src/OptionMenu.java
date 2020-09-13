import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
//valid login information customer number and pin number:
	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(123456, 123456);
				data.put(8989898, 1890);
				data.put(8239898, 2890);
				System.out.println("Welcome to ATM Project !");

				System.out.println("Enter your Customer number: ");
				setCustomerNumber(menuInput.nextInt());

				System.out.println("Enter your secret pin: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers" + "\n");
				x = 2;
			}
			for (Entry<Integer, Integer> entry : data.entrySet()) {
				if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\n" + "Wrong Customer number or pin"+"\n");
		} while (x == 1);
	}

//display account type menu with selection
	public void getAccountType() {
		System.out.println("Select the account you want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			getChecking();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank you for using this ATM.");
			break;

		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();
		}
	}

	// Display Checking Account Menu with selections

	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Desposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye");
			break;
		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getChecking();
		}

	}

//Display Saving Account Menu with selections:
	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw funds");
		System.out.println("Type 3 - Desposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye");
			break;
		default:
			System.out.println("\n" + "Invalid Choice" + "\n");
			getSaving();
		}
	}
}
