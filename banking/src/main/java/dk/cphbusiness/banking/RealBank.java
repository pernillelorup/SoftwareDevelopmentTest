package dk.cphbusiness.banking;

import java.util.HashMap;
import java.util.List;

public class RealBank implements Bank {

    private String cvr;
    private String name;
    private HashMap<String, Account> accounts;
    private HashMap<String, Customer> customers;

    public RealBank(String cvr, String name) {
        this.cvr = cvr;
        this.name = name;
        this.accounts = new HashMap<String, Account>();
        this.customers = new HashMap<String, Customer>();
    }

    @Override
    public Account getAccount(String number) {
        return accounts.get(number);
    }

    @Override
    public List<Account> getAccounts(Customer customer) {
        return customer.getAccounts();
    }

    public HashMap<String, Account> getAllAccounts() {
        return accounts;
    }

    public String getCvr() {
        return cvr;
    }

    @Override
    public void registerAccount(Account account) {
        accounts.put(account.getNumber(), account);
    }

    @Override
    public Customer getCustomer(String cpr) {
        return customers.get(cpr);
    }

    @Override
    public void registerCustomer(Customer customer) {
        customers.put(customer.getCpr(), customer);
    }

    @Override
    public String getName() {
        return name;
    }
}
