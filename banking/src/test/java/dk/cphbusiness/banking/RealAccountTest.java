package dk.cphbusiness.banking;

import org.junit.Test;
import static org.junit.Assert.*;

public class RealAccountTest {

  @Test
  public void testCreateAccount() throws Exception {
    Bank bank = new BankDummy();
    Customer customer = new CustomerDummy();
    String number = null;
    RealAccount account = new RealAccount(bank, customer, number);
    assertNotNull(account);
    }

  @Test
  public void testCreateAccountWithBank() {
    Bank bank = new BankDummy();
    Customer customer = new CustomerDummy();
    String number = null;
    RealAccount account = new RealAccount(bank, customer, number);
    assertEquals(bank, account.getBank());
    assertNotNull(account.getBank());
    }

  @Test
  public void testCreateAccountWithNumber() {
    Bank bank = new BankDummy();
    Customer customer = new CustomerDummy();
    String number = "ABC12345";
    RealAccount account = new RealAccount(bank, customer, number);
    assertEquals(number, account.getNumber());
    assertNotNull(account.getNumber());
    }

  @Test
  public void testCreateAccountWithZeroBalance() {
    Bank bank = new BankDummy();
    Customer customer = new CustomerDummy();
    String number = "ABC12345";
    RealAccount account = new RealAccount(bank, customer, number);
    assertEquals(0L, account.getBalance());
    }

  @Test
  public void testTransferPositiveAmount() {
    Bank bank = new BankDummy();
    Customer customer = new CustomerDummy();
    String number = "ABC12345";
    RealAccount source = new RealAccount(bank, customer, "SRC12345");
    RealAccount target = new RealAccount(bank, customer, "TGT12345");
    source.transfer(10000, target);
    assertEquals(-10000, source.getBalance());
    assertEquals(10000, target.getBalance());
    }

  @Test
  public void testTransferPositiveAmountUsingNumber() {
    BankStub bank = new BankStub();
    Customer customer = new CustomerDummy();
    String targetNumber = "TGT12345";
    RealAccount target = new RealAccount(bank, customer, targetNumber);
    RealAccount source = new RealAccount(bank, customer, "SRC12345");
    bank.setAccount(target);

    source.transfer(10000, targetNumber);
    assertEquals(-10000, source.getBalance());
    assertEquals(10000, target.getBalance());
    }


  }
