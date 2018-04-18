package account;


import utils.Utils;

public class AccountImpl implements Account{

    private long digitAccountNumber;
    private String name;
    private String socialSecurityNumber;
    private AccountType accountType;
    private double deposit;


    public AccountImpl() {
    }

    public AccountImpl(String name, String socialSecurityNumber, account.AccountType accountType, double deposit) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.accountType = accountType;
        this.deposit = deposit;
       String generate = Utils.returnOneorTwoDependingOnAccountType(this.accountType) +Utils.getLastTwoDigitsOfSSN(this.socialSecurityNumber) +"" +Utils.getFiveDigitRandomNumber()+ "" + Utils.getRandomThreeDigitNumber();
        this.digitAccountNumber = Long.parseLong(generate);
    }

    public long getDigitAccountNumber() {
        return digitAccountNumber;
    }

    public void setDigitAccountNumber(long digitAccountNumber) {
        this.digitAccountNumber = digitAccountNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(account.AccountType accountType) {
        this.accountType = accountType;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public void transfer(Account person, double amount) {
            if(!validateAmountAndDeposit(amount)) {
                System.out.println("Given amount is bigger than user's deposit -> amount=" + amount + ", deposit=" + this.deposit+ " \n");
                return;
            }

            person.deposit(amount);
            this.deposit-=amount;
    }

    @Override
    public void withdraw(double amount) {
        if(!validateAmountAndDeposit(amount)) {
            System.out.println("Given amount is bigger than user's deposit -> amount=" + amount + ", deposit=" + this.deposit+ " \n");
            return;
        }

        this.deposit-=amount;

    }

    private boolean validateAmountAndDeposit(double amount) {
        if(deposit - amount < 0) {
             return false;
        }

        return true;
    }

    @Override
    public void deposit(double amount) {
        if(amount < 1) {
            System.out.println("Given amount cannot be less than 1");
            return;
        }

        this.deposit+= amount;
    }

    @Override
    public void showInfo() {
        this.toString();
    }

    @Override
    public String toString() {
        return "AccountImpl{" +
                "name='" + name + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", accountType=" + accountType +
                ", deposit=" + deposit +
                '}';
    }
}
