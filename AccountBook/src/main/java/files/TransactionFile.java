package files;

import models.Transaction;
import models.TransactionManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TransactionFile {
    private TransactionManager transactionManager;

    public TransactionFile(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void initFile(File file) throws FileNotFoundException {
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

    public void updateFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for (Transaction transaction : transactionManager.transactions()) {
            fileWriter.write(
                            transaction.date() + "," +
                            transaction.type() + "," +
                            transaction.payment() + "," +
                            transaction.amount() + "," +
                            transaction.comment()
            );
        }

        fileWriter.close();
    }
}
