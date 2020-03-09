package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RealAccount implements Account {
    private Bank bank;
    private Customer customer;
    private String number;
    private long balance = 0;
    private List<Movement> movements;

    public RealAccount(Bank bank, Customer customer, String number) {
        this.bank = bank;
        this.customer = customer;
        this.number = number;
        this.movements = new ArrayList<>();
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public Customer getCustomer() {
        return customer;
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
        movements.add(new Movement(source, target, amount, new Date()));
    }

    @Override
    public void updateBalance(long amount) {
      balance += amount;
    }

    @Override
    public List<Movement> getMovements() {
        return movements;
    }

    @Override
    public void transfer(long amount, Account target) {
        updateBalance(-amount);
        target.updateBalance(amount);
        addMovement(this, target, -amount);
        target.addMovement(target, this, amount);
    }

    @Override
    public void transfer(long amount, String targetNumber) {
        Account target = bank.getAccount(targetNumber);
        transfer(amount, target);
    }
}
