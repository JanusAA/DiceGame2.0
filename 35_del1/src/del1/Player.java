package del1;

public class Player {

	private String name;
	private int balance;
	
	//Constructor:
	public Player(String name, int balance){
		this.name = name;
		this.balance = balance;
		}

	//getters and setters. 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	/**
	 * addToCurrentBalance adds amount to the total balance and returns the new balance. 
	 * @param amount
	 * @return
	 */
	public int addToCurrentBalance(int amount){
		balance = balance + amount;
		return balance;
	}
	

public String toString (){
	return ( "Spiller: " + name + " points: " + balance);
}
	
	
}
