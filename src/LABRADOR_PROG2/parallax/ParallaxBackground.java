package LABRADOR_PROG2.parallax;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParallaxBackground extends JPanel implements ActionListener {
    private final int width = 1280;
    private final int height = 720;

    // Position of the background
    private int backgroundX = 0;

    private final Timer timer;
    private final Image background;

    public ParallaxBackground() {
        // Load the background image
        background = new ImageIcon("src/LABRADOR_PROG2/parallax/Bg.jpg").getImage();

        setPreferredSize(new Dimension(width, height));

        // Timer for the game loop, fires every 16 ms (~60 FPS)
        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image and loop it by drawing a second copy
        g.drawImage(background, backgroundX, 0, null);
        g.drawImage(background, backgroundX + width, 0, null);  // Draw the second copy right after the first one
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move the background
        backgroundX -= 2;  // Speed of the background movement (adjust for faster or slower)

        // Reset position when the image has fully moved off-screen
        if (backgroundX <= -width) {
            backgroundX = 0;
        }

        // Redraw the panel
        repaint();
    }

    static void main(String[] args) {
        JFrame frame = new JFrame("Moving Background Example");
        ParallaxBackground bg = new ParallaxBackground();
        frame.add(bg);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}