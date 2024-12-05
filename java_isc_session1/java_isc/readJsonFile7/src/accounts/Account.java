package accounts;

public class Account {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("balancss")
	private int balance;
	
	@JsonProperty("transaction")
	private transaction t;
	
	public Account(String name, int balance, transaction t) {
		super();
		this.name = name;
		this.balance = balance;
		this.t = t;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	public transaction getT() {
		return t;
	}
	public void setT(transaction t) {
		this.t = t;
	}
	
	@Override
	public String toString() {
		return "account [name=" + name + ", balance=" + balance + ", t=" + t + "]";
	}
}