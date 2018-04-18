package account;

import static utils.Constants.SAVINGS;

public class AccountType {

    private String type;

    private double interestRate;

    public AccountType(double interest) {
        if(getType().equals(SAVINGS)) {
           this. interestRate = 0.25;
        }
        this.interestRate = BaseInterestRate.BASE_INTEREST - interest;
    }

    public AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
