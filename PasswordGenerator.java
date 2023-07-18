import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class PasswordGenerator extends JFrame {

    private JTextField lengthField;
    private JTextField characterSetField;
    private JButton generateButton;
    private JLabel passwordLabel;

    public PasswordGenerator() {
        super("Password Generator");

        // Set up the layout.
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        // Create the text fields.
        lengthField = new JTextField(5);
        characterSetField = new JTextField(10);

        // Create the button.
        generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = Integer.parseInt(lengthField.getText());
                String characterSet = characterSetField.getText();
                String password = generatePassword(length, characterSet);
                passwordLabel.setText(password);
            }
        });

        // Create the label.
        passwordLabel = new JLabel("");

        // Add the components to the content pane.
        contentPane.add(lengthField);
        contentPane.add(characterSetField);
        contentPane.add(generateButton);
        contentPane.add(passwordLabel);

        // Set the window size, default close operation, and make it visible.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    private String generatePassword(int length, String characterSet) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int characterIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(characterIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGenerator();
            }
        });
    }
}
