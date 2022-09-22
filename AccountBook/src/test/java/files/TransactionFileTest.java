package files;

import models.Transaction;
import models.TransactionManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFileTest {
    @Test
    void initFile() throws FileNotFoundException {
        TransactionManager transactionManager = new TransactionManager();

        TransactionFile transactionFile = new TransactionFile(transactionManager);

        transactionFile.initFile();
        
        assertEquals("testDate", transactionManager.transactions().get(0).date());
        assertEquals("testType", transactionManager.transactions().get(0).type());
        assertEquals("testPayment", transactionManager.transactions().get(0).payment());
        assertEquals(0, transactionManager.transactions().get(0).amount());
        assertEquals("testComment", transactionManager.transactions().get(0).comment());
    }

    @Test
    void updateFile() {
        TransactionManager transactionManager = new TransactionManager();

        TransactionFile transactionFile = new TransactionFile(transactionManager);
    }
}
