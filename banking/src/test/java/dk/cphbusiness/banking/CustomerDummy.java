package dk.cphbusiness.banking;

import java.util.List;

public class CustomerDummy implements Customer {

  @Override
  public void transfer(long amount, Account account, Customer target) {

  }

  @Override
  public String getCpr() {
    return null;
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
