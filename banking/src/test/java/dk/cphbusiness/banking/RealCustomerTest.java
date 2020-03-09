package dk.cphbusiness.banking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RealCustomerTest {

    RealCustomer customer;
    AccountStub account1, account2;
    BankDummy bank;
    List<Account> accounts;
    final String ACCOUNT_NUMBER1 = "ABC1234";
    final String ACCOUNT_NUMBER2 = "DEF5678";

    @Before
    public void setUp() throws Exception {
        accounts = new ArrayList<>();
        account1 = new AccountStub(ACCOUNT_NUMBER1, 100);
        account2 = new AccountStub(ACCOUNT_NUMBER2, 100);
        accounts.add(account1);
        customer = new RealCustomer("123456-7890", "Adam", bank, accounts);
    }

    @Test
    public void testTransfer() {
        customer.transfer(50, account2, customer);
        assertEquals(account1.getBalance(), 150);
        assertEquals(account2.getBalance(), 50);
    }
}
