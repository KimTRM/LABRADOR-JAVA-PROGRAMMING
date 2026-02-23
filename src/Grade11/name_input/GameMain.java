package Grade11.name_input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMain extends JFrame {
    private String playerName;

    public GameMain() {
        setTitle("Game Name Input");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Enter your player's name: ");
        JTextField nameField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(submitButton);

        // Add the input panel to the frame
        add(inputPanel, BorderLayout.CENTER);

        // Handle the submit button action
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = nameField.getText();
                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name cannot be empty!");
                } else {
                    startGame();
                    System.exit(0);
                }
            }
        });
    }

    private void startGame() {
        // Here you would start the game, using playerName as needed
        System.out.println("Player name: " + playerName);
        // Example: new GameWorld(playerName).start();
    }

    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameMain game = new GameMain();

            game.setUndecorated(true);
            game.setLocationRelativeTo(null);
            game.setVisible(true);
        });
    }
}
