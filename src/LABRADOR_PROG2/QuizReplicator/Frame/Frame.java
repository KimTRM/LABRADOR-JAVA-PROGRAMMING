package LABRADOR_PROG2.QuizReplicator.Frame;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
    static void main(String[] args) {

        JFrame window = new JFrame();
        Panel panel = new Panel();

        window.setTitle("Quiz Simulator");

        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
        window.setBackground(Color.DARK_GRAY);
    }
}

class Panel extends JPanel implements Runnable {
    File[] file = new File[5];
    List<Question> questionList = new ArrayList<>();

    public Font Pixel;

    public String Question;
    public String A, B, C, D;
    public String correctAnswer;

    public Panel() {
        final int WINDOW_WIDTH = 1280;
        final int WINDOW_HEIGHT = 720;
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setFocusable(true);

        file[0] = new File("src/LABRADOR_PROG2/QuizReplicator/res/Question.txt");

        getQuestion(0);
        GetFont();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    }

    // -- Location of Text --
    int TextBoxY = 380;

    int TextBoxAX = 320;
    int TextBoxAY = TextBoxY;

    int TextBoxBX = 320;
    int TextBoxBY = TextBoxY + 150;

    int TextBoxCX = 680;
    int TextBoxCY = TextBoxY;

    int TextBoxDX = 680;
    int TextBoxDY = TextBoxY + 150;

    int Boxlenght = 300;
    int Boxwidth = 120;

    int FontSize = 30;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // -- QUESTION BOX --
        g2.setColor(new Color(73, 29, 0));
        g2.drawRect(250, 10, 800, 300);
        g2.setColor(new Color(255, 253, 208));
        g2.fillRect(250, 10, 800, 300);

        // -- A --
        g2.setColor(new Color(73, 29, 0));
        g2.drawRect(TextBoxAX, TextBoxAY, Boxlenght, Boxwidth);
        g2.setColor(new Color(255, 253, 208));
        g2.fillRect(TextBoxAX, TextBoxAY, Boxlenght, Boxwidth);

        // -- B --
        g2.setColor(new Color(73, 29, 0));
        g2.drawRect(TextBoxBX, TextBoxBY, Boxlenght, Boxwidth);
        g2.setColor(new Color(255, 253, 208));
        g2.fillRect(TextBoxBX, TextBoxBY, Boxlenght, Boxwidth);

        // -- C --
        g2.setColor(new Color(73, 29, 0));
        g2.drawRect(TextBoxCX, TextBoxCY, Boxlenght, Boxwidth);
        g2.setColor(new Color(255, 253, 208));
        g2.fillRect(TextBoxCX, TextBoxCY, Boxlenght, Boxwidth);

        // -- D --
        g2.setColor(new Color(73, 29, 0));
        g2.drawRect(TextBoxDX, TextBoxDY, Boxlenght, Boxwidth);
        g2.setColor(new Color(255, 253, 208));
        g2.fillRect(TextBoxDX, TextBoxDY, Boxlenght, Boxwidth);

        g.setColor(Color.BLACK);
        int Qy = 180;
        int Qx = 320;
        PrintTexts(Question, Qx, Qy - 50, 64, 55, false, g2);

        PrintTexts(A, TextBoxAX + 25, TextBoxAY + 70, 42, FontSize, false, g2);
        PrintTexts(B, TextBoxBX + 25, TextBoxBY + 70, 42, FontSize, false, g2);
        PrintTexts(C, TextBoxCX + 25, TextBoxCY + 70, 42, FontSize, false, g2);
        PrintTexts(D, TextBoxDX + 25, TextBoxDY + 70, 42, FontSize, false, g2);
    }

    public void GetFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/LABRADOR_PROG2/QuizReplicator/res/x12y16pxMaruMonica.ttf");
            Pixel = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    public void PrintTexts(String text, int x, int y, int ln, int size, boolean ForceColor, Graphics2D g) {
        if (ForceColor) {
            g.setColor(new Color(73, 29, 0));
        }

        g.setFont(Pixel);
        g.setFont(g.getFont().deriveFont(Font.BOLD, size));
        for (String line : text.split("\\\\n")) {
            if (text.length() > 23) {
                y -= 15;
            }

            g.drawString(line, x, y);
            y += ln; // Adjust the increment as needed for your line spacing
        }
    }

    public void getQuestion(int x) {
        Scanner inputFile;

        try {
            inputFile = new Scanner(file[x]);

            StringBuilder fileContent = new StringBuilder();

            while (inputFile.hasNext()) {
                String s = inputFile.nextLine();
                fileContent.append(s).append("\n");
            }

            String[] perQuestion = fileContent.toString().split("///");

            // Populate questionList with Question objects
            for (String questionString : perQuestion) {
                // Skip empty lines
                if (questionString.trim().isEmpty()) {
                    continue;
                }
                String[] token = questionString.split("\n");
                if (token.length >= 6) {
                    Question question = new Question();
                    question.question = token[1];
                    question.first = token[2];
                    question.second = token[3];
                    question.third = token[4];
                    question.fourth = token[5];
                    question.correctAnswer = token[6];

                    questionList.add(question);
                } else {
                    System.out.println("Incomplete question format: " + questionString);
                }
            }

            random();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void random() {
        Collections.shuffle(questionList);
        // Ask questions and get user's answers
        for (Question question : questionList) {
            Question = question.question;
            A = question.first;
            B = question.second;
            C = question.third;
            D = question.fourth;
            correctAnswer = question.correctAnswer;

        }
    }

}

class Question {
    String question;
    String first, second, third, fourth;
    String correctAnswer;
}
