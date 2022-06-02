package myapp.core;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;

public class MapMain {

    private static BankAccount acct;

    public static void main(String[] args) {

        BankAccount fred = new BankAccount("fred");
        BankAccount barney = new BankAccount("barney");
        BankAccount wilma = new BankAccount("wilma");
        BankAccount betty = new BankAccount("betty");


        // Create a simple Map
        Map<String, BankAccount> accts = new HashMap<>();
        accts.put(fred.getAccountID(), fred);
        accts.put(barney.getAccountID(), barney);
        accts.put(wilma.getAccountID(), wilma);
        accts.put(betty.getAccountID(), betty);

        System.out.printf("size: %d\n", accts.size());
        System.out.printf("has fred: %b\n", accts.containsKey(fred.getAccountID()));
        System.out.printf("has pebbles: %b\n", accts.containsKey("pebbles"));

        Set<String> keys = accts.keySet();
        Collection<BankAccount> values = accts.values();
        
        // To loop keys
        for (String acctId: keys) {
            acct = accts.get(acctId);
            System.out.printf("acctid = %s, name = %s\n", acctId, acct.getName());
            
        }
}
}