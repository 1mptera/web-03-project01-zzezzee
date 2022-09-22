package files;

import models.Transaction;
import models.TransactionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionFile {
    private TransactionManager transactionManager;

    public TransactionFile(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void initFile() throws FileNotFoundException {
        File file = new File("Transaction.csv");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");

            String date = words[0];
            String type = words[1];
            String payment = words[2];
            int amount = Integer.parseInt(words[3]);
            String comment = words[4];

            transactionManager.addTransaction(new Transaction(date, type, payment, amount, comment));
        }
    }
}
