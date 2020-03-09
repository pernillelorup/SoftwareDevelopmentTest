package dk.cphbusiness.banking;

import java.util.Date;

public class Movement {

    private Account source;
    private Account target;
    private long amount;
    private Date timestamp;

    public Movement(Account source, Account target, long amount, Date timestamp) {
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Account getSource() {
        return source;
    }

    public Account getTarget() {
        return target;
    }

    public long getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }


}