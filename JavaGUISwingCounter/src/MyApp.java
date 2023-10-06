import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyApp extends JFrame {
    static int currentValue = 0;

    public static void main(String[] args) {
        new MyApp();
    }

    public MyApp() {
        setTitle("My Java GUI Swing Counter");
        setSize(600, 400);
        setResizable(false);

        JPanel panelMain = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panelMain, BoxLayout.Y_AXIS);
        panelMain.setLayout(boxLayout);


        JLabel lblAppTitle = new JLabel("My GUI Swing Counter");
        Font font1 = new Font("Arial", Font.BOLD, 32);
        lblAppTitle.setFont(font1);
        panelMain.add(lblAppTitle);


        JTextField txtCounter = new JTextField("0", 32);
        txtCounter.setHorizontalAlignment(SwingConstants.CENTER);
        txtCounter.setEditable(false);
        txtCounter.setBackground(Color.YELLOW);
        Font font2 = new Font("Arial", Font.BOLD, 75);
        txtCounter.setFont(font2);
        panelMain.add(txtCounter);

        JButton btnCount = new JButton("Count");
        Font font3 = new Font("Arial", Font.PLAIN, 24);
        btnCount.setFont(font3);
        btnCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentValue++;

                txtCounter.setText(
                        String.valueOf(currentValue)
                );
            }
        });
        panelMain.add(btnCount);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(font3);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentValue = 0;

                txtCounter.setText("0");
            }
        });
        panelMain.add(btnReset);

        add(panelMain);

        setVisible(true);
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosed(e);

                        System.exit(0);
                    }
                }
        );
    }
}