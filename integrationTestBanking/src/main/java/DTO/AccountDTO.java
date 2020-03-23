package DTO;

import java.util.List;

public class AccountDTO {

    public double balance;
    public String number;
    public List<MovementDTO> movements;

    public AccountDTO(double balance, String number, List<MovementDTO> movements){
        this.balance = balance;
        this.number = number;
        this.movements = movements;
    }
}
