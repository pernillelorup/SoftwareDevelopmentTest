package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
  private Bank bank;
  private Customer customer;
  private String number;
  private long balance = 0;
  private List<Movement> movements;

  public Account(Bank bank, Customer customer, String number) {
    this.bank = bank;
    this.customer = customer;
    this.number = number;
    this.movements = new ArrayList<>();
    }

  public Bank getBank() {
    return bank;
    }

  public Customer getCustomer() {
    return customer;
    }

  public String getNumber() {
    return number;
    }

  public long getBalance() {
    return balance;
    }

  public List<Movement> getMovements() {
    return movements;
  }

  //withdraw from own account -> transfer to another target account
  public void transfer(long amount, Account target) {
    balance -= amount;
    target.balance += amount;
    movements.add(new Movement(this, target, amount, new Date()));
    }

    //deposit
  public void transfer(long amount, String targetNumber) {
    Account target = bank.getAccount(targetNumber);
    transfer(amount, target);

     }
  }
