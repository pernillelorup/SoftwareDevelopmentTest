package dk.cphbusiness.miscellaneous;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Customer;

import java.util.List;

public class BaseCustomer implements Customer {
  public BaseCustomer(String number, String name) { }

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
}
