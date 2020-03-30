package dk.cphbusiness.banking;

import java.util.List;

public class AccountStub implements Account {
    private String number;
    private long balance = 0;

    public AccountStub(String number, long balance){
        this.number = number;
        this.balance = balance;
    }

    public AccountStub(String number) {
        this(number, 0);
    }

    @Override
    public Bank getBank() {
        return null;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public void addMovement(Account source, Account target, long amount) {
    }

    @Override
    public void updateBalance(long amount) {
        balance += amount;
    }

    @Override
    public List<Movement> getMovements() {
        return null;
    }

    @Override
    public void transfer(long amount, Account target) {
        updateBalance(-amount);
        target.updateBalance(amount);
    }

    @Override
    public void transfer(long amount, String targetNumber) {

    }
}
