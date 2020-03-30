package dk.cphbusiness.banking;

import java.util.List;

public class CustomerStub implements Customer {

    private String cpr;

    public CustomerStub(String cpr) {
        this.cpr = cpr;
    }

    @Override
    public void transfer(long amount, Account account, Customer target) {
    }

    @Override
    public String getCpr() {
        return cpr;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public List<Movement> getMovementsFromAccount(String accountNumber) {
        return null;
    }
}
