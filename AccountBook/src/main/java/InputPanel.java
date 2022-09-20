import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class InputPanel extends JPanel {
    private JPanel contentPanel;

    public InputPanel() {
        setBackground(SystemColor.activeCaption);
        setBounds(0, 0, 600, 420);
        setBackground(Color.ORANGE);
        setLayout(null);


        initContentPanel();
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0,2));
        contentPanel.setBounds(0, 0, 600, 420);

        contentPanel.setBackground(Color.PINK);

        initButtons();

        add(contentPanel);
    }

    private void initButtons() {
        JLabel label1 = new JLabel("날짜 : ");

        JLabel label2 = new JLabel("");
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(label4);
        contentPanel.add(label5);
    }
}
