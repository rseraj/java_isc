package taskSession3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account hasan = new Account(200,"Hasan","001");
		Account ali = new Account(122,"Ali","002");
		Account mahi = new Account(700,"Mahi", "003");
		Account negin = new Account (564,"Negin", "003");
		Account amir = new Account (600,"Amir","001");
		
		//create a list of accounts(1)
		Account[] accountArray= {hasan,ali,mahi,negin,amir};
		List<Account> accountList = Arrays.asList(accountArray);
		
		//print accounts(2)
		System.out.println(accountList);
		
		//sort accounts(3)
		//form highest to lowest
		Collections.sort(accountList);
		System.out.println(accountList);
		
		//reverse sort accounts(4)
		//from lowest to highest
		Collections.sort(accountList, Comparator.reverseOrder());
		System.out.println("Reverse sort accounts: " + accountList);
		
		//create map(5)
		Map<String, List<Account>> mapAccount = new HashMap<>();
		
		mapAccount.put("001", new ArrayList<>());
		mapAccount.put("002", new ArrayList<>());
		mapAccount.put("003", new ArrayList<>());

		
		for (Account user : accountList) {
			mapAccount.get(user.getBranch()).add(user);
		}
		//print map(6)
		System.out.println("\nmapped by branch:");
		
		for (Map.Entry<String, List<Account>> entry : mapAccount.entrySet()) {
			String key = entry.getKey();
			List<Account> val = entry.getValue();
			System.out.println("Branch: " + key + "Account:" + val);
			
		}
        
        
        //remove from map branch=002(7)
        mapAccount.remove("002");
        System.out.println("\nafter remove:");
        for (Map.Entry<String, List<Account>> entry : mapAccount.entrySet()) {
			String key = entry.getKey();
			List<Account> val = entry.getValue();
			System.out.println("Branch: " + key + "Account:" + val);
			
		}

	}
	}


	
