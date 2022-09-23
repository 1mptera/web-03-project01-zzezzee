package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoTest {

    @Test
    void create() {
        Memo memo = new Memo("이건메모");
    }

    @Test
    void editMemo() {
        Memo memo = new Memo("이건메모");

        memo.editMemo("안녕");

        assertEquals("안녕", memo.memo());
    }
}
