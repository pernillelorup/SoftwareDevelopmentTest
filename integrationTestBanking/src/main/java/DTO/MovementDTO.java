package DTO;

public class MovementDTO {

    public String accountNumber;
    public double amount;

    public MovementDTO(String accountNumber, double amount){
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

}
