package LABRADOR_PROG2.name_input;

import javax.swing.*;
import java.awt.*;

public class Leaderboard {

    static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to undecorated (no title bar)
        frame.setUndecorated(true);

        // Set the frame's background color to black
        frame.getContentPane().setBackground(Color.BLACK);

        // Create a panel for custom window decoration (e.g., title bar)
        JPanel titleBar = new JPanel();
        titleBar.setBackground(Color.BLACK);
        titleBar.setPreferredSize(new Dimension(frame.getWidth(), 30)); // Set title bar height
        titleBar.setLayout(new BorderLayout());

        // Add a close button
        JButton closeButton = new JButton("X");
        closeButton.setForeground(Color.WHITE);
        closeButton.setBackground(Color.BLACK);
        closeButton.setBorder(null);

        closeButton.addActionListener(e -> System.exit(0));

        titleBar.add(closeButton, BorderLayout.EAST);

        // Add title bar to the top of the frame
        frame.add(titleBar, BorderLayout.NORTH);

        // Add some content to the frame
        JLabel label = new JLabel("Custom Black Window Decoration", JLabel.CENTER);
        label.setForeground(Color.WHITE);
        frame.add(label, BorderLayout.CENTER);

        // Pack and show the frame
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

}
