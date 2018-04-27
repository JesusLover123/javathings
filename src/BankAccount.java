/**
 * 
 * @author Noah Harrigan
 * Is a bank account that stores balance, account number, and name, and is abstract
 */
public abstract class BankAccount 
{
	// fields
	private static int nextAccNum = 0;
	private String name;
	private int acctNum;
	private double balance;
	
	//constructors
	/**
	 * constructor that makes a bank account including a name, account number (starts at 1 and increments for each subsequent account), and has a balance of 0
	 * @param n is the name of the account holder
	 */
	public BankAccount(String n)
	{
		this(n, 0);
	}
	/**
	 * constructor that makes a bank account including a name, account number (starts at 1 and increments for each subsequent account), and has a balance that is initialized to b
	 * @param n is the account holder name
	 * @param b is the balance 
	 */
	public BankAccount(String n, double b)
	{
		name = n;
		balance = b;
		nextAccNum++;
		acctNum = nextAccNum;
	}
	
	//methods
	/**
	 * puts a certain amount of money into the account 
	 * @param amt the amount of money going into the account
	 */
	public void deposit(double amt)
	{
		balance+=amt;
	}
	
	/**
	 * takes a certain amount of money out of the account
	 * @param amt is the amount of money going out of the account
	 */
	public void withdraw(double amt)
	{
		balance-=amt;
	}
	
	/**
	 * returns the name of the account
	 * @return the field, name, which is the name of the account
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * returns the balance of the account
	 * @return the field, balance, which is the balance of account
	 */
	public double getBalance()
	{
		return balance;
	}
	
	public int getAccountNumber()
	{
		return acctNum;
	}
	
	/**
	 * performs all tasks necessary for the end of the month and a new beginning
	 */
	abstract public void endOfMonthUpdate();
	/**
	 * transfers money from one account to another, but only if they are under the same name
	 * @param other the account receiving the money
	 * @param amt the amount of money being transferred
	 */
	abstract public void transfer(BankAccount other, double amt);
	
	/**
	 * returns the state of the bank account as a string
	 */
	abstract public String toString();
}

