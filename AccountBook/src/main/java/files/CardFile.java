package files;

import models.Account;
import models.Card;
import models.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CardFile {
    private User user;

    public CardFile(User user) {
        this.user = user;
    }

    public void initFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(",");

            String cardName = words[0];
            String linkedAccount = words[1];

            user.addCard(new Card(cardName, linkedAccount));
        }
    }

    public void updateFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for(Card card : user.card()){
            fileWriter.write(card.name() + "," + card.linkedAccount() + "\n");
        }

        fileWriter.close();
    }
}
