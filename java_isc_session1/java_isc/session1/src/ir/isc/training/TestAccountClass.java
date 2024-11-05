package ir.isc.training;



public class TestAccountClass {
    public static void main(String[] args) {
        Account account1 = new Account(1000.0, "Central Branch");
        account1.print();
        account1.withDraw(200.0);

        System.out.println();

        Account account2 = new Account(500.0);
        account2.lockAccount();
        account2.print();
        account2.withDraw(100.0); 
    }
}
