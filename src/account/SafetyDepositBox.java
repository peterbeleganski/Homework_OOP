package account;

import static utils.Utils.depositCount;

public class SafetyDepositBox {

    private int id;
    private String code;

    public SafetyDepositBox() {
        depositCount++;
        this.id = depositCount;
    }

    public SafetyDepositBox(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code.length() != 4) {
            System.out.println("Deposit Box code must be 4 digits");
            return;
        }
        this.code = code;
    }
}
