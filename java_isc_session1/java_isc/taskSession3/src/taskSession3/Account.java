package taskSession3;

import java.util.Objects;

public class Account implements Comparable<Account> {
	
	// Constructors
	public Account(int balance, String name, String branch) {
		super();
		this.balance = balance;
		this.name = name;
		this.branch = branch;
	}
	
	//properties
	
	private int balance;
	private String name;
	private String branch;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account{name='" + name + "', balance=" + balance + ", branch=" + branch + "}";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance);
	}
	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return o.balance - this.balance;
	}
	

}
