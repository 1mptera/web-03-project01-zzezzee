package files;

import models.Memo;
import models.MemoManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MemoFileTest {

    @Test
    void initFile() throws IOException {
        MemoManager memoManager = new MemoManager();
        MemoFile memoFile = new MemoFile(memoManager);

        File file = new File("MemoTest.csv");

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("메모메모");

        fileWriter.close();

        memoFile.initFile(file);

        assertEquals("메모메모", memoManager.getMemos().get(0).memo());
    }

    @Test
    void updateFile() throws IOException {
        MemoManager memoManager = new MemoManager();
        MemoFile memoFile = new MemoFile(memoManager);

        File file = new File("MemoTest.csv");

        Scanner scanner =new Scanner(file);

        memoManager.add((new Memo("메모업데이트")));

        memoFile.updateFile(file);

        String line = scanner.nextLine();

        assertEquals("메모업데이트", line);
    }
}
