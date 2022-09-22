package files;

import models.Transaction;
import models.TransactionManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFileTest {

    @Test
    void initFile() throws IOException {
        TransactionManager transactionManager = new TransactionManager();

        TransactionFile transactionFile = new TransactionFile(transactionManager);

        File file = new File("TransactionTest.csv");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("testDate,testType,testPayment,0,testComment");

        fileWriter.close();

        transactionFile.initFile(file);

        assertEquals("testDate", transactionManager.transactions().get(0).date());
        assertEquals("testType", transactionManager.transactions().get(0).type());
        assertEquals("testPayment", transactionManager.transactions().get(0).payment());
        assertEquals(0, transactionManager.transactions().get(0).amount());
        assertEquals("testComment", transactionManager.transactions().get(0).comment());
    }

    @Test
    void updateFile() throws IOException {
        TransactionManager transactionManager = new TransactionManager();

        TransactionFile transactionFile = new TransactionFile(transactionManager);

        File file = new File("TransactionTest.csv");

        Scanner scanner = new Scanner(file);

        transactionManager.addTransaction(new Transaction("09-22", "수입", "재원통장", 500, "주움"));

        transactionFile.updateFile(file);

        String line1 = scanner.nextLine();

        assertEquals("09-22,수입,재원통장,500,주움", line1);
    }
}
