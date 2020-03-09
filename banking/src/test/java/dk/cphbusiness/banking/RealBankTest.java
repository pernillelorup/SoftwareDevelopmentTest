package dk.cphbusiness.banking;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RealBankTest {

    RealBank bank;
    AccountStub account;
    CustomerStub customer;
    final String ACCOUNT_NUMBER = "ABC1234";
    final String CPR = "123456-7890";

    @Before
    public void setUp() throws Exception {
        bank = new RealBank("1234", "CorporateBank");
        account = new AccountStub(ACCOUNT_NUMBER);
        customer = new CustomerStub(CPR);
    }

    @Test
    public void testRegisterAndGetAccount() {
        bank.registerAccount(account);
        Account createdAccount = bank.getAccount(ACCOUNT_NUMBER);
        assertEquals(account, createdAccount);
    }

    @Test
    public void testRegisterAndGetCustomer() {
        bank.registerCustomer(customer);
        Customer createdCustomer = bank.getCustomer(CPR);
        assertEquals(customer, createdCustomer);
    }



}
