package account;

public class DebitCard {

    private int id;
    private String pin;

    public DebitCard(String pin) {
        this.setPin(pin);
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        if(pin.length() != 12 ) {
            System.out.println("Credit card Pin must be 12 digits long!");
            return;
        }
        this.pin = pin;
    }
}
