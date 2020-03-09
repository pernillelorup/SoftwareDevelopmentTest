package dk.cphbusiness.banking;

import java.util.List;

public interface Customer {
    void transfer(long amount, Account account, Customer target);
    String getCpr();
    List<Account> getAccounts();

}
