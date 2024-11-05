package ir.isc.training;


import java.util.Date;

public class Account {
    // Properties
    private double balance;
    private String branch;
    private boolean locked;
    private Date lastTransaction;

    // Constructors
    public Account(double balance) {
        this.balance = balance;
        this.branch = "Unknown"; 
        this.locked = false;     
        this.lastTransaction = new Date(); 
    }

    public Account(double balance, String branch) {
        this.balance = balance;
        this.branch = branch;
        this.locked = false;    
        this.lastTransaction = new Date();
    }

    // Getter و Setter 
    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public boolean isLocked() {
        return locked;
    }

    public void lockAccount() {
        this.locked = true;
    }

    public void unlockAccount() {
        this.locked = false;
    }

    public Date getLastTransaction() {
        return lastTransaction;
    }

    // Methods
    public void print() {
        System.out.println("Account Information:");
        System.out.println("Balance: " + balance);
        System.out.println("Branch: " + branch);
        System.out.println("Locked: " + (locked ? "true" : "false"));
        System.out.println("Last Transaction: " + lastTransaction);
    }

    public void withDraw(double amount) {
        if (locked) {
            System.out.println("Error: Account is locked, withDraw not allowed.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds for withDraw.");
        } else {
            balance -= amount;
            lastTransaction = new Date(); 
            System.out.println("WithDraw of " + amount + " was successful.");
            System.out.println("New Balance: " + balance);
        }
    }
}


