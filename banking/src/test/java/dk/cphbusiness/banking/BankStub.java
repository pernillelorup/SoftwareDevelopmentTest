package dk.cphbusiness.banking;

import java.util.List;

public class BankStub implements Bank {
  private RealAccount account;

  void setAccount(RealAccount account) {
    this.account = account;
    }

  @Override
  public RealAccount getAccount(String number) {
    return account;
    }

  @Override
  public List<Account> getAccounts(Customer customer) {
    return null;
  }

  @Override
  public void registerAccount(Account account) {

  }

  @Override
  public Customer getCustomer(String number) {
    return null;
    }

  @Override
  public void registerCustomer(Customer customer) {

  }

  @Override
  public String getName() {
    throw new UnsupportedOperationException();
    }
  }
