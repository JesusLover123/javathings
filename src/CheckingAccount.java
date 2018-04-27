/**
 * 
 * @author Noah Harrigan
 * Subclass of BankAccount that creates a checking account that adds a number of transactions, the amount of free transactions allowed, the transaction fee for going over the amount of free transactions, and a fee for overdrafting  (withdrawing the account until it is in the negative) 
 */
public class CheckingAccount extends BankAccount
{
	//fields
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final int FREE_TRANS;
	private int numTransactions;
	
	//constructors
	/**
	 * constructor that makes a checking account taking a name, balance, overdraft fee, transaction fee, and number of free transactions as parameters
	 * @param n account holder name
	 * @param b initial balance
	 * @param odf over draft fee
	 * @param tf a fee for going over the transaction limit
	 * @param freeTrans the amount of free transactions allowed
	 */
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		numTransactions = 0;
	}
	
	/**
	 * constructor that makes a checking account taking a name, overdraft fee, transaction fee, and number of free transactions as parameters, and balance initialized to 0
	 * @param n account holder name 
	 * @param odf overdraft fee
	 * @param tf transaction fee
	 * @param freeTrans number of free transactions alloted
	 */
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		this(n, 0, odf, tf, freeTrans);
	}
	
	//methods
	/**
	 * overrides super's deposit, deposit the amount of money and increments number of transactions and then takes out the fee if the number of transactions is greater than the amount of transactions allowed. throws an illegalargumentexception if the transaction is not valid
	 * @param amt is the amount of money being deposited
	 */
	public void deposit(double amt)
	{
			if(amt < 0)
			{
				throw new IllegalArgumentException();
			}
			numTransactions++;
			if(numTransactions > FREE_TRANS)
			{
				super.withdraw(TRANSACTION_FEE);
			}
			super.deposit(amt);
	}
	
	/**
	 * overrides super's withdraw, withdraws the amount of money and increments number of transactions and then takes out the fee if the number of transactions is greater than the amount of transactions allowed. throws an illegalargumentexception if the transaction is not valid
	 * @param amt is the amount of money being withdrawn
	 */
	public void withdraw(double amt)
	{
			if(super.getBalance() <= 0 || amt < 0)
			{
				throw new IllegalArgumentException();
			}
			numTransactions++;
			if(super.getBalance() - amt < 0)
			{
				super.withdraw(OVER_DRAFT_FEE);
			}
			if(numTransactions > FREE_TRANS)
			{
				super.withdraw(TRANSACTION_FEE);
			}
			super.withdraw(amt);
	}
	
	/**
	 * overrides super's transfer, transfers amt money from the called object to the parameter object, throws an illegalargumentexception if illegitimate transacation
	 * @param other is the account with money getting transferred to it 
	 * @param amt  is the amount of money being transferred
	 */
	public void transfer(BankAccount other, double amt)
	{
			if(super.getBalance() <= 0 || amt < 0 || super.getBalance() - amt < 0 || !other.getName().equals(super.getName()))
			{
				throw new IllegalArgumentException();
			}
			other.deposit(amt);
			super.withdraw(amt);
	}
	
	/**
	 * overrides super's endofmonthupdate method, performs all tasks required at the end of each month
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	
	public String toString()
	{
		return super.getAccountNumber() + "\tCheckingAccount\t" + super.getName() + "\t$" + super.getBalance();
	}
}