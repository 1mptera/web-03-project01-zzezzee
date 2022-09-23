package files;

import models.Account;
import models.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountFileTest {

    @Test
    void initFile() throws IOException {
        User user = new User();
        AccountFile accountFile = new AccountFile(user);

        File file = new File("AccountTest.csv");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("재원통장,10000");

        fileWriter.close();

        accountFile.initFile(file);

        assertEquals("재원통장", user.account().get(0).name());
        assertEquals(10000, user.account().get(0).amount());
    }

    @Test
    void updateFile() throws IOException {
        User user = new User();
        AccountFile accountFile = new AccountFile(user);

        File file = new File("AccountTest.csv");

        Scanner scanner = new Scanner(file);

        user.addAccount(new Account("재원통장", 10000));

        accountFile.updateFile(file);

        String line = scanner.nextLine();

        assertEquals("재원통장,10000", line);
    }
}
