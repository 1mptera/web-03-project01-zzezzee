package files;

import models.Account;
import models.Transaction;
import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountFile {

    private User user;

    public AccountFile(User user) {
        this.user = user;
    }

    public void initFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");

            String accountName = words[0];
            int amount = Integer.parseInt(words[1]);

            user.addAccount(new Account(accountName, amount));
        }
    }


    public void updateFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for(Account account : user.account()){
            fileWriter.write(account.name() + "," + account.amount());
        }

        fileWriter.close();
    }
}
