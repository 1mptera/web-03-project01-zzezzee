package files;

import models.Transaction;
import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CashFile {
    private User user;

    public CashFile(User user) {
        this.user = user;
    }

    public void initFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int amount = Integer.parseInt(scanner.nextLine());

        user.receiveCash(amount);
    }

    public void updateFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(Integer.toString(user.cash()));

        fileWriter.close();
    }
}
