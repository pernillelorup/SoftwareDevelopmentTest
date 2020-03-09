package dk.cphbusiness.banking;

import java.util.Date;
import java.util.List;

public interface Account {

    public Bank getBank();
    public Customer getCustomer();
    public String getNumber();
    public long getBalance();
    public void addMovement(Account source, Account target, long amount);
    public void updateBalance(long amount);
    public List<Movement> getMovements();
    public void transfer(long amount, Account target);
    public void transfer(long amount, String targetNumber);
}
