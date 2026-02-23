package LABRADOR_PROG2.cursor;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class thing {

    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Cursor Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Load a custom cursor image
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image cursorImage = toolkit.getImage("src/Grade11/something/cursor.png"); // Replace with your image path

            // Set the hotspot offsets
            Point hotspot = new Point(30, 30); // Offset x=10, y=10 from top-left of the image

            // Create a custom cursor
            Cursor customCursor = toolkit.createCustomCursor(cursorImage, hotspot, "Custom Cursor");

            // Apply the custom cursor to the frame
            frame.setCursor(customCursor);

            // Add a label for demonstration
            JLabel label = new JLabel("Hover around to see the custom cursor!", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);
        });
    }

}
