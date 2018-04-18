import account.Account;
import account.AccountImpl;
import account.AccountType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static void main(String[] args) {

        String csvFile = "test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<Account> accounts = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] person = line.split(cvsSplitBy);

                String name = person[0];
                String ssn = person[1];
                String type = person[2];
                double deposit = Double.parseDouble(person[3]);

                Account currAccount = new AccountImpl(name,ssn, new AccountType(type),deposit);
                accounts.add(currAccount);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println();

    }
}
