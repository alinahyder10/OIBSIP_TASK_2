/** A subclass of the number guessing game that sets up all the different panels of the game and generates a random number
 * Alina Hyder
 * 22/11/2024
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGenerator {
    private JTextField guess;
    private JButton confirmButton, giveUpButton, tryAgainButton, exitButton;
    private JPanel guessPanel, endPanel;
    private JLabel numberOfAttempts, score;

    public JPanel playGamePanel(){
        guessPanel = new JPanel();
        guessPanel.setOpaque(true);
        guessPanel.setBounds(0,   100,800,500);
        guessPanel.setLayout(null);
        guessPanel.setVisible(true);

        JLabel instruction = new JLabel("Enter a number between 1 and 100");
        instruction.setForeground(Color.BLACK);
        instruction.setFont(new Font("DialogInput",Font.BOLD,20));
        instruction.setOpaque(true);
        instruction.setBounds(0,0,800,40);
        instruction.setHorizontalAlignment(SwingConstants.CENTER);
        guessPanel.add(instruction);

        guess = new JTextField();
        guess.setPreferredSize(new Dimension(150,50));
        guess.setFont(new Font("DialogInput",Font.BOLD,70));
        guess.setForeground(Color.BLACK);
        guess.setBounds(300,50,200,100);
        guess.setHorizontalAlignment(SwingConstants.CENTER);
        guessPanel.add(guess);

        confirmButton = new JButton("OK");
        confirmButton.setBounds(305,170,70,50);
        confirmButton.setFocusable(false);
        confirmButton.setFont(new Font("DialogInput",Font.BOLD,20));
        confirmButton.setBackground(Color.GRAY);
        confirmButton.setForeground(Color.WHITE);
        guessPanel.add(confirmButton);

        giveUpButton = new JButton("GIVE UP");
        giveUpButton.setBounds(385,170,110,50);
        giveUpButton.setFocusable(false);
        giveUpButton.setFont(new Font("DialogInput",Font.BOLD,17));
        giveUpButton.setBackground(Color.GRAY);
        giveUpButton.setForeground(Color.WHITE);
        guessPanel.add(giveUpButton);

        return guessPanel;
    }

    public JPanel gameOverPanel(){
        endPanel = new JPanel();
        endPanel.setOpaque(true);
        endPanel.setBounds(0,   100,800,500);
        endPanel.setLayout(null);
        endPanel.setVisible(true);

        JLabel message = new JLabel("Game Over!");
        message.setForeground(Color.RED);
        message.setFont(new Font("DialogInput",Font.BOLD,60));
        message.setOpaque(true);
        message.setBounds(230,0,400,60);
        endPanel.add(message);

        tryAgainButton = new JButton("PLAY AGAIN");
        tryAgainButton.setBounds(315,210,160,70);
        tryAgainButton.setFocusable(false);
        tryAgainButton.setFont(new Font("DialogInput",Font.BOLD,20));
        tryAgainButton.setBackground(Color.GRAY);
        tryAgainButton.setForeground(Color.WHITE);
        endPanel.add(tryAgainButton);

        exitButton = new JButton("EXIT");
        exitButton.setBounds(342,300,110,50);
        exitButton.setFocusable(false);
        exitButton.setFont(new Font("DialogInput",Font.BOLD,18));
        exitButton.setBackground(Color.GRAY);
        exitButton.setForeground(Color.WHITE);
        endPanel.add(exitButton);

        return endPanel;
    }

    public int generate(){
        Random number = new Random();
        return number.nextInt(1,101);
    }

    public void correctGuess(){
        JLabel congratsMessage = new JLabel("Congratulations!");
        congratsMessage.setBounds(0,60,800,80);
        congratsMessage.setHorizontalAlignment(SwingConstants.CENTER);
        congratsMessage.setOpaque(true);
        congratsMessage.setFont(new Font("DialogInput",Font.BOLD,45));
        congratsMessage.setForeground(Color.PINK);
        endPanel.add(congratsMessage);

        JLabel successMessage = new JLabel("You have successfully guessed the number.");
        successMessage.setBounds(30,120,800,80);
        successMessage.setOpaque(true);
        successMessage.setFont(new Font("DialogInput",Font.BOLD,30));
        successMessage.setForeground(Color.PINK);
        endPanel.add(successMessage);
    }

    public void gameOver(int answer){
        JLabel inform = new JLabel("The correct number was");
        inform.setBounds(0,60,800,80);
        inform.setHorizontalAlignment(SwingConstants.CENTER);
        inform.setOpaque(true);
        inform.setFont(new Font("DialogInput",Font.BOLD,40));
        inform.setForeground(Color.RED);
        endPanel.add(inform);

        JLabel number = new JLabel(String.valueOf(answer));
        number.setBounds(0,120,800,80);
        number.setOpaque(true);
        number.setFont(new Font("DialogInput",Font.BOLD,50));
        number.setHorizontalAlignment(SwingConstants.CENTER);
        number.setForeground(Color.RED);
        endPanel.add(number);
    }

    public void displayInformation(){
        numberOfAttempts = new JLabel();
        numberOfAttempts.setForeground(Color.BLACK);
        numberOfAttempts.setFont(new Font("DialogInput",Font.BOLD,16));
        numberOfAttempts.setBounds(300,280,400,50);
        numberOfAttempts.setOpaque(true);
        guessPanel.add(numberOfAttempts);

        score = new JLabel();
        score.setForeground(Color.BLACK);
        score.setFont(new Font("DialogInput",Font.BOLD,16));
        score.setBounds(300,240,200,50);
        score.setOpaque(true);
        guessPanel.add(score);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getGiveUpButton() {
        return giveUpButton;
    }

    public JTextField getGuess() {
        return guess;
    }

    public JButton getTryAgainButton() {
        return tryAgainButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JLabel getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public JLabel getScore() {
        return score;
    }
}
