import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class makingChange {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new RegisterPanel());
        frame.setVisible(true);
    }

    public static class RegisterPanel extends JPanel {
        final Register register;
        final JTextField input;
        final PursePanel changePanel;

        public RegisterPanel() {
            register = new Register();
            input = new JTextField();
            changePanel = new PursePanel();
            JPanel inputPanel = new JPanel();

            input.setPreferredSize(new Dimension(100, 50));
            input.addActionListener(new InputListener());


            inputPanel.add(input);

            setLayout(new BorderLayout());
            add(inputPanel, BorderLayout.NORTH);
            add(changePanel, BorderLayout.CENTER);

        }

        private class InputListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(input.getText());
                Purse change = register.makeChange(amount);
                changePanel.setPurse(change);
                changePanel.repaint();
            }
        }
    }

    static class PursePanel extends JPanel {
        private Purse purse;

        public PursePanel() {
            purse = new Purse();
        }

        public void setPurse(Purse purse) {
            this.purse = purse;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (purse != null) {
                g.setColor(Color.BLACK);
                g.setFont(new Font("Times New Roman", Font.BOLD, 15));

                String Display = "Change: " + purse.toString();
                g.drawString(Display, 10, 20);
            }
        }
    }
}

