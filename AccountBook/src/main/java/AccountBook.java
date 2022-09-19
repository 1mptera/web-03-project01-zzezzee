import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;

public class AccountBook {
    JFrame frame;
    private JPanel memoPanel;
    private JPanel menuPanel;
    private JPanel assetPanel;
    private JPanel inputPanel;
    private JPanel transactionPanel;

    public static void main(String[] args) {
        AccountBook application = new AccountBook();
        application.run();
    }

    private void run() {
        frame = new JFrame();
        frame.setBackground(SystemColor.activeCaption);
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        assetPanel = new JPanel();
        assetPanel.setBackground(SystemColor.activeCaption);
        assetPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(assetPanel);
        assetPanel.setLayout(null);
        assetPanel.setVisible(false);

        inputPanel = new JPanel();
        inputPanel.setBackground(SystemColor.activeCaption);
        inputPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(inputPanel);

        JButton btnNewButton_4 = new JButton("InputPanel");
        inputPanel.add(btnNewButton_4);

        transactionPanel = new JPanel();
        transactionPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(transactionPanel);
        transactionPanel.setLayout(null);

        JButton sdf = new JButton("New button");
        sdf.setBounds(0, 0, 117, 29);
        transactionPanel.add(sdf);

        memoPanel = new JPanel();
        memoPanel.setBounds(0, 0, 800, 420);
        frame.getContentPane().add(memoPanel);
        memoPanel.setLayout(null);

        JButton btnNewButton_1 = new JButton("MemoPanel");
        btnNewButton_1.setBounds(341, 5, 314, 223);
        memoPanel.add(btnNewButton_1);

        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 800, 480);
        frame.getContentPane().add(menuPanel);
        menuPanel.setLayout(null);

        inputPanel.setVisible(false);
        transactionPanel.setVisible(true);
        memoPanel.setVisible(false);

        JButton inputButton = new JButton("입력");
        inputButton.addActionListener(event -> {
            inputPanel.setVisible(true);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(false);
            memoPanel.setVisible(false);
        });
        inputButton.setBounds(0, 423, 200, 50);
        inputButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(inputButton);

        JButton transactionsButton = new JButton("내역");
        transactionsButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(true);
            assetPanel.setVisible(false);
            memoPanel.setVisible(false);
        });
        transactionsButton.setBounds(200, 423, 200, 50);
        transactionsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(transactionsButton);

        JButton assetButton = new JButton("자산");
        assetButton.setBounds(400, 423, 200, 50);
        assetButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        assetButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(true);
            memoPanel.setVisible(false);
        });
        menuPanel.add(assetButton);

        JButton memoButton = new JButton("메모");
        memoButton.addActionListener(event -> {
            inputPanel.setVisible(false);
            transactionPanel.setVisible(false);
            assetPanel.setVisible(false);
            memoPanel.setVisible(true);
        });

        memoButton.setBounds(600, 423, 200, 50);
        memoButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        menuPanel.add(memoButton);

        frame.setVisible(true);
    }
}
