package files;

import models.Account;
import models.Memo;
import models.MemoManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MemoFile {
    private MemoManager memoManager;

    public MemoFile(MemoManager memoManager) {
        this.memoManager = memoManager;
    }

    public void initFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            memoManager.add(new Memo(line));
        }
    }

    public void updateFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        for(Memo memo : memoManager.getMemos()){
            fileWriter.write(memo.memo() + "\n");
        }

        fileWriter.close();
    }
}
