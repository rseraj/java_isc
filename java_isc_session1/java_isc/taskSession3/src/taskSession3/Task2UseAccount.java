package taskSession3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Task2UseAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account hasan = new Account(200,"Hasan","001");
		Account ali = new Account(122,"Ali","002");
		Account mahi = new Account(700,"Mahi", "003");
		Account negin = new Account (564,"Negin", "003");
		Account amir = new Account (600,"Amir","001");
		
		Account[] account2Arr ={hasan, ali, mahi, negin, amir};
		List<Account> accountList2 = Arrays.asList(account2Arr);
		
		for (Iterator<Account> iterator = accountList2.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			account.setName(account.getName().toUpperCase());
			System.out.println(account.getName());	
			
		}
		List<Account>account3 = new ArrayList<Account>();
		for (Iterator<Account> iterator = accountList2.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();
			if(account.getBalance()>400 && account.getName().startsWith("A", 0) )
				account3.add(account);
			//System.out.println(account3);
			
		}
		System.out.println(account3);
	}

}
