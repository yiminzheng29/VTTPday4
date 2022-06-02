package myapp.core;

import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MapMain2 {

    private static BankAccount acct;
    private static char[] BankAccount;
    private static String name;
    private static Map<String, myapp.core.BankAccount> accts;

    public static void main(String[] args) {

        List<String> names = new LinkedList<>();
        names.add("fred");
        names.add("barney");
        names.add("wilma");
        names.add("betty");

        Map<String, BankAccount> accts = new HashMap<>();

        for (String n: names) {
            BankAccount acct = new BankAccount(n);
            accts.put(acct.getAccountID(), acct);
        }

        Set<String> keys = accts.keySet();
        Collection<BankAccount> values = accts.values();
        
        // To loop keys
        for (String acctId: keys) {
            acct = accts.get(acctId);
            System.out.printf("acctid = %s, name = %s\n", acctId, acct.getName());
            
        }
}
}