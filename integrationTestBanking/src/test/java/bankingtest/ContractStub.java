package bankingtest;

import DTO.AccountDTO;
import DTO.MovementDTO;
import interfaces.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractStub implements Contract {

    public List<AccountDTO> getAccountsOnCPR(String cpr) {

        if(cpr == null){
            return null;
        } else if(cpr.equals(ContractTest.CPR)) {
            List<AccountDTO> accounts = new ArrayList<AccountDTO>();
            List<MovementDTO> movements1 = new ArrayList<MovementDTO>();

            movements1.add(new MovementDTO(ContractTest.ACC4, ContractTest.AMO1));
            movements1.add(new MovementDTO(ContractTest.ACC2, ContractTest.AMO2));

            List<MovementDTO> movements2 = new ArrayList<MovementDTO>();

            movements2.add(new MovementDTO(ContractTest.ACC3, ContractTest.AMO3));

            AccountDTO account1 = new AccountDTO(ContractTest.BAL1, ContractTest.ACC1, movements1);
            AccountDTO account2 = new AccountDTO(ContractTest.BAL2, ContractTest.ACC2, movements2);

            accounts.add(account1);
            accounts.add(account2);

            return accounts;
        } else if(cpr.length() != 10){
            return null;
        } else {
            return null;
        }
    }

    public boolean transfer(String sourceNumber, String targetNumber, double amount) {
        if(targetNumber == null
                || sourceNumber == null
                || amount <= 0
                || targetNumber.equals(sourceNumber)
                || targetNumber.length() != 8
                || sourceNumber.length() != 8
        ){
            return false;
        } else if(targetNumber.equals(ContractTest.ACC1) && sourceNumber.equals(ContractTest.ACC2) && amount > 0) {
            return true;
        }
        return false;
    }
}
