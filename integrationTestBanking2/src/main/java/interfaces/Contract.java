package interfaces;

import DTO.AccountDTO;

import java.util.List;

public interface Contract {

    public List<AccountDTO> getAccountsOnCPR(String cpr);
    public boolean transfer(String sourceNumber, String targetNumber, double amount);

}
