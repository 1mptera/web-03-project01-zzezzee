package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoManagerTest {

    @Test
    void addMemo() {
        MemoManager memoManager = new MemoManager();

        memoManager.add(new Memo("이건메모"));

        assertEquals("이건메모", memoManager.getMemos().get(0).memo());
    }

    @Test
    void editMemo() {
        MemoManager memoManager = new MemoManager();

        Memo memo = new Memo("안녕");

        memoManager.editMemo(memo, "잘가");

        assertEquals("잘가", memo.memo());
    }
}
