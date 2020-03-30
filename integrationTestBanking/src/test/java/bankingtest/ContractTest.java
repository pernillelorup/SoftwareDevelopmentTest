package bankingtest;

import DTO.AccountDTO;
import DTO.MovementDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ContractTest {

    ContractStub contract;
    public static final String CPR = "1111111111";
    public static final String ACC1 = "11111111";
    public static final String ACC2 = "22222222";
    public static final String ACC3 = "33333333";
    public static final String ACC4 = "44444444";
    public static final double BAL1 = 23;
    public static final double BAL2 = 10;
    public static final double AMO1 = 25;
    public static final double AMO2 = -2;
    public static final double AMO3 = 10;

    @Before
    public void setUp() throws Exception {
        contract = new ContractStub();

    }

    @Test
    public void testGetAccountsOnCPRIsNull(){
        List<AccountDTO> result = contract.getAccountsOnCPR(null);
        assertNull(result);
    }

    @Test
    public void testGetAccountsOnCPR(){
        List<AccountDTO> result = contract.getAccountsOnCPR(CPR);
        assertEquals(2, result.size());

        AccountDTO acc1 = result.get(0);
        assertEquals(BAL1, acc1.balance);

        MovementDTO mov1 = acc1.movements.get(0);
        assertEquals(ACC4, mov1.accountNumber);
        assertEquals(AMO1, mov1.amount);

        MovementDTO mov2 = acc1.movements.get(1);
        assertEquals(ACC2, mov2.accountNumber);
        assertEquals(AMO2, mov2.amount);


        AccountDTO acc2 = result.get(1);
        assertEquals(BAL2, acc2.balance);

        MovementDTO mov3 = acc2.movements.get(0);
        assertEquals(ACC3, mov3.accountNumber);
        assertEquals(AMO3, mov3.amount);


    }

    @Test
    public void testGetAccountOnCPRInvalidCPRLength(){
        List<AccountDTO> result1 = contract.getAccountsOnCPR("1111");
        assertNull(result1);

        List<AccountDTO> result2 = contract.getAccountsOnCPR("111111111111111");
        assertNull(result2);
    }

    @Test
    public void testGetAccountOnCPRNotExists(){
        List<AccountDTO> result1 = contract.getAccountsOnCPR("2222222222");
        assertNull(result1);
    }

    @Test
    public void testTransferTargetIsNull(){
        boolean result = contract.transfer(ACC1, null, AMO3);
        assertFalse(result);
    }

    @Test
    public void testTransferSourceIsNull(){
        boolean result = contract.transfer(null, ACC1, AMO3);
        assertFalse(result);
    }

    @Test
    public void testTransferAmountIsZero(){
        boolean result = contract.transfer(ACC1, ACC2, 0);
        assertFalse(result);
    }

    @Test
    public void testTransferAmountIsNegative(){
        boolean result = contract.transfer(ACC1, ACC2, -2);
        assertFalse(result);
    }

    @Test
    public void testTransferAmountTargetAndSourceAreEqual(){
        boolean result = contract.transfer(ACC1, ACC1, AMO3);
        assertFalse(result);
    }

    @Test
    public void testTransferAmountTargetLength(){
        boolean result = contract.transfer(ACC1, "1111111111111111", AMO3);
        assertFalse(result);
    }

    @Test
    public void testTransferAmountSourceLength(){
        boolean result = contract.transfer("1111", ACC1, AMO3);
        assertFalse(result);
    }

    @Test
    public void testTransfer(){
        boolean result = contract.transfer(ACC1, ACC2, 20);
        assertTrue(result);
    }

    @Test
    public void testTransferNotExists(){
        boolean result = contract.transfer(ACC1, "99999999", 20);
        assertTrue(result);
    }

}
