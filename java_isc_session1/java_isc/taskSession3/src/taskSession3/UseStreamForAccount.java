package taskSession3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UseStreamForAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account hasan = new Account(200,"Hasan","001");
		Account ali = new Account(122,"Ali","002");
		Account mahi = new Account(700,"Mahi", "003");
		Account negin = new Account (564,"Negin", "003");
		Account amir = new Account (600,"Amir","001");
		
		Account[] account2Arr2 ={hasan, ali, mahi, negin, amir};
		List<Account> accountList3 = Arrays.asList(account2Arr2);
		
		accountList3.forEach(t -> t.setName(t.getName().toUpperCase()));
		
		List<Account> filterAccount =accountList3.stream()
        .filter(t -> t.getBalance()>400 )
        .filter(t -> t.getName().startsWith("A"))
        .collect(Collectors.toList());
		
		System.out.println(accountList3);
		
		System.out.println(filterAccount);
		
		
		
		
	}

}
