package dk.cphbusiness.banking;

import java.util.List;

public class RealCustomer implements Customer {

    private String cpr;
    private String name;
    private Bank bank;
    private List<Account> accounts;

    public RealCustomer(String cpr, String name, Bank bank, List<Account> accounts) {
        this.cpr = cpr;
        this.name = name;
        this.bank = bank;
        this.accounts = accounts;
    }

    @Override
    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void transfer(long amount, Account account, Customer target) {
        //Giver ingen mening. Spørg Anders!!!!
        account.transfer(amount, target.getAccounts().get(0));
    }

    public List<Movement> getMovementsFromAccount(String accountNumber) {
        List<Movement> movementList = null;
        for (Account a:accounts) {
            if(a.getNumber().equals(accountNumber)) {
                movementList = a.getMovements();
            }
        }
        return movementList;
    }
}
