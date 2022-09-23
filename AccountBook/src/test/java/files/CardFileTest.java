package files;

import models.Card;
import models.User;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CardFileTest {

    @Test
    void initFile() throws IOException {
        User user = new User();
        CardFile cardFile = new CardFile(user);

        File file = new File("CardTest.csv");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("재원카드,재원통장");

        fileWriter.close();

        cardFile.initFile(file);

        assertEquals("재원카드", user.card().get(0).name());
        assertEquals("재원통장", user.card().get(0).linkedAccount());
    }

    @Test
    void updateFile() throws IOException {
        User user = new User();
        CardFile cardFile = new CardFile(user);

        File file = new File("CardTest.csv");

        Scanner scanner = new Scanner(file);

        user.addCard(new Card("재원카드", "재원통장"));

        cardFile.updateFile(file);

        String line = scanner.nextLine();

        assertEquals("재원카드,재원통장", line);
    }
}
