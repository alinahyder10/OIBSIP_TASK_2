/** A subclass of the number guessing game that sets up the main panel and evaluates the guesses
 * Alina Hyder
 * 22/11/2024
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final JButton startButton;
    private JButton confirmButton, giveUpButton, tryAgainButton, exitButton;
    private final JPanel startMenu;
    private JPanel numberPanel, endPanel;
    private int solution, score, attempts;
    private JTextField answer;
    private JLabel attemptsLabel;

    public Game(){
        this.score = 0;
        this.attempts = 10;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Number Guessing Game");
        this.setResizable(false);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("GuessMyNumber.png");
        this.setIconImage(image.getImage());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setOpaque(true);
        titlePanel.setBounds(0,0,800,100);
        this.add(titlePanel);

        JLabel title = new JLabel("Guess The Number");
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("SansSerif",Font.BOLD,50));
        titlePanel.add(title,BorderLayout.CENTER);

        startMenu = new JPanel();
        startMenu.setOpaque(true);
        startMenu.setBounds(0,100,800,500);
        startMenu.setLayout(null);
        startMenu.setVisible(true);
        this.add(startMenu);

        JLabel prompt = new JLabel("Press start to begin!");
        prompt.setForeground(Color.BLACK);
        prompt.setOpaque(true);
        prompt.setBounds(205,0,800,50);
        prompt.setFont(new Font("DialogInput", Font.BOLD,30));
        startMenu.add(prompt);

        startButton = new JButton("START!");
        startButton.setBounds(335,70,110,50);
        startButton.addActionListener(this);
        startButton.setFont(new Font("DialogInput",Font.BOLD,21));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.GRAY);
        startButton.setFocusable(false);
        startMenu.add(startButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton){
            startMenu.setVisible(false);
            playGame();
        }

        if (e.getSource() == confirmButton){
            if (!answer.getText().isEmpty() && !answer.getText().matches(".*[a-zA-Z].*")) {
                int guess = Integer.parseInt(answer.getText());
                if (guess == solution) {
                    endGame();
                    numberGenerator.correctGuess();
                    score++;
                } else {
                    attemptsLabel.setText("Attempts Remaining: " + --attempts);
                    if (attempts > 0) {
                        if (guess < solution) {
                            JOptionPane.showMessageDialog(null, "Your guess is incorrect. \nThe correct value is GREATER than this.", "INCORRECT GUESS", JOptionPane.PLAIN_MESSAGE);
                        } else if (guess > solution) {
                            JOptionPane.showMessageDialog(null, "Your guess is incorrect. \nThe correct value is SMALLER than this.", "INCORRECT GUESS", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }
            }
            if (attempts == 0){
                endGame();
                numberGenerator.gameOver(solution);
            }
        }
        else if (e.getSource() == giveUpButton){
            endGame();
            numberGenerator.gameOver(solution);
        }

        if (e.getSource() == tryAgainButton){
            endPanel.setVisible(false);
            attempts = 10;
            playGame();
        }
        else if (e.getSource() == exitButton){
            System.exit(0);
        }

        this.revalidate();
        this.repaint();
    }

    private void endGame(){
        numberPanel.setVisible(false);
        endPanel = numberGenerator.gameOverPanel();
        this.add(endPanel);

        tryAgainButton = numberGenerator.getTryAgainButton();
        tryAgainButton.addActionListener(this);

        exitButton = numberGenerator.getExitButton();
        exitButton.addActionListener(this);
    }

    private void playGame(){
        numberPanel = numberGenerator.playGamePanel();
        confirmButton = numberGenerator.getConfirmButton();
        confirmButton.addActionListener(this);

        giveUpButton = numberGenerator.getGiveUpButton();
        giveUpButton.addActionListener(this);

        answer = numberGenerator.getGuess();
        answer.addActionListener(this);

        solution = numberGenerator.generate();

        numberGenerator.displayInformation();
        JLabel scoreLabel = numberGenerator.getScore();
        scoreLabel.setText("Score: " + score);

        attemptsLabel = numberGenerator.getNumberOfAttempts();
        attemptsLabel.setText("Attempts Remaining: " + attempts);

        this.add(numberPanel);
    }
}
