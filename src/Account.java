import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	// Set the Customer number
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

//Get the Customer number
	public int getCustomerNumber() {
		return customerNumber;
	}

//Set the Pin number
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

// Get the pin number
	public int getPinNumber() {
		return pinNumber;
	}

//Get checking Account Balance
	public double getCheckingBalance() {
		return checkingBalance;
	}

//Get Saving Account Balance
	public double getSavingBalance() {
		return savingBalance;
	}

//calculate checking account withdrawl
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

//calculate saving account withdrawl
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	// Calculate checking Account deposit
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	// Calculate saving Account deposit
	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
//customer checking account withdraw input

	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account balance: " + moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();

		if ((checkingBalance - amount) >= 0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Balance cannot be negetive");
		}
	}

//customer saving account withdraw input
	public void getSavingWithdrawInput() {
		System.out.println("saving Account balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to withdraw from saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			calcSavingWithdraw(amount);
			System.out.println("New saving Account balance: " + savingBalance + "\n");
		} else {
			System.out.println("Balance cannot be negetive" + "\n");
		}
	}

	// customer checking account deposit input
	public void getCheckingDepositInput() {
		System.out.println("Checking Account balance: " + moneyFormat.format(checkingBalance));
		System.out.println("Amount you want to deposit into Checking Account: ");
		double amount = input.nextDouble();
		if ((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			System.out.println("New Checking Account balance: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Balance cannot be negetive"+"\n");
		}
	}

	// customer saving account deposit input
	public void getSavingDepositInput() {
		System.out.println("saving Account balance: " + moneyFormat.format(savingBalance));
		System.out.println("Amount you want to deposit into saving Account: ");
		double amount = input.nextDouble();
		if ((savingBalance + amount) >= 0) {
			calcSavingDeposit(amount);
			System.out.println("New saving Account balance: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Balance cannot be negetive"+"\n");
		}
	}

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
}
