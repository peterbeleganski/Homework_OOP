package utils;

import account.AccountType;

import java.util.Random;

import static utils.Constants.SAVINGS;

public class Utils {

    public static int depositCount = 100;

    public static String getRandomThreeDigitNumber() {

        Random rand = new Random();
        Integer pick = rand.nextInt(900) + 100;
        return pick.toString();
    }

    public static String returnOneorTwoDependingOnAccountType(AccountType user) {
        if(user.equals(SAVINGS)) {
            return  "1";
        }

        return "2";
    }

    public static String getLastTwoDigitsOfSSN(String SSN) {
        return SSN.substring(SSN.length() - 2);
    }

    public static String getFiveDigitRandomNumber() {
        Long millis = System.currentTimeMillis() / 100000000;

        return millis.toString();
    }
}
