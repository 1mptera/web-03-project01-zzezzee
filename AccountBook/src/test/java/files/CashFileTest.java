package files;

import models.Ledger;
import models.Transaction;
import models.TransactionManager;
import models.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CashFileTest {

    @Test
    void initFile() throws IOException {
        User user = new User();

        CashFile cashFile = new CashFile(user);

        File file = new File("CashTest.csv");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("5000");

        fileWriter.close();

        cashFile.initFile(file);

        assertEquals(5000, user.cash());
    }

    @Test
    void updateFile() throws IOException {
        User user = new User();
        TransactionManager transactionManager = new TransactionManager();
        Ledger ledger = new Ledger(user, transactionManager);

        CashFile cashFile = new CashFile(user);

        File file = new File("CashTest.csv");

        Scanner scanner = new Scanner(file);

        ledger.transferTransaction(new Transaction("09-22", "수입", "현금", 500, "주움"));

        cashFile.updateFile(file);

        String line = scanner.nextLine();

        assertEquals("500", line);


    }
}
