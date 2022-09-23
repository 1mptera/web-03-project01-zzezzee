package models;

import java.util.ArrayList;
import java.util.List;

public class MemoManager {
    private List<Memo> memos = new ArrayList<>();

    public void add(Memo memo) {
        memos.add(memo);
    }

    public List<Memo> getMemos() {
        return memos;
    }

    public void editMemo(Memo memo, String content) {
        memo.editMemo(content);
    }
}
