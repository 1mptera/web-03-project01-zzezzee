package models;

public class Memo {
    private String memo;

    public Memo(String memo) {
        this.memo = memo;
    }

    public String memo() {
        return memo;
    }

    public void editMemo(String content) {
        this.memo = content;
    }
}
