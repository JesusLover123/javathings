/**
 * 
 * @author Noah Harrigan Subclass of Bank Account that creates a Savings
 *         Account, which tracks (in addition to what Bank Account tracks) the
 *         interest rate, minimum balance, and the minimum balance fee
 */
public class SavingsAccount extends BankAccount {
	// fields
	private double intRate;
	private static double MIN_BAL;
	private static double MIN_BAL_FEE;

	// constructors
	/**
	 * Creates a SavingsAccount with name, balance, rate, minimum balance, and
	 * minimum balance fee initialized
	 * 
	 * @param n
	 *            Account holder name
	 * @param b 
	 *            Initial balance
	 * @param r
	 *            Interest rate (per month)
	 * @param mb
	 *            Minimum balance allowed
	 * @param mbf
	 *            Minimum balance fee
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf) {
		super(n, b);
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
		intRate = r;
	}

	/**
	 * Creates a SavingsAccount with name, rate, minimum balance, and minimum
	 * balance fee initialized
	 * 
	 * @param n
	 *            Accountholder name
	 * @param r
	 *            Interest rate (per month)
	 * @param mb
	 *            Minimum balance allowed
	 * @param mbf
	 *            Minimum balance fee
	 */
	public SavingsAccount(String n, double r, double mb, double mbf) {
		this(n, 0, r, mb, mbf);
	}

	// methods
	/**
	 * Withdraws a specified amount from the account (throws
	 * IllegalArgumentException if invalid)
	 * 
	 * @param amt
	 *            Amount to be withdrawn
	 */
	public void withdraw(double amt) {
		if (super.getBalance() <= 0 || amt < 0 || super.getBalance() - amt < 0) {
			throw new IllegalArgumentException();
		}
		if ((super.getBalance() - amt < MIN_BAL)) {
			super.withdraw(MIN_BAL_FEE);
		}
		super.withdraw(amt);
	}

	/**
	 * Transfers a specified amount from the account being called to the account
	 * that is the parameter (throws IllegalArgumentException if invalid)
	 * 
	 * @param other
	 *            The account receiving money from the account being called
	 * @param amt
	 *            Amount to be transferred
	 */
	public void transfer(BankAccount other, double amt) {
		if (super.getBalance() <= 0 || amt < 0 || super.getBalance() - amt < 0
				|| !other.getName().equals(super.getName())) {
			throw new IllegalArgumentException();
		}
		other.deposit(amt);
		super.withdraw(amt);
	}

	/**
	 * Adds interest to the account
	 */
	public void addInterest() {
		super.deposit(super.getBalance() + super.getBalance() * intRate);
	}

	/**
	 * Performs all necessary tasks for the end of the month (adds interest)
	 */
	public void endOfMonthUpdate() {
		addInterest();
	}

	public String toString() 
	{
		return super.getAccountNumber() + "\tSavingsAccount\t" + super.getName() + "\t$" + super.getBalance();
	}
}
