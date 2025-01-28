
/**
* Hangman_v3_final_fixed.java
*
* DESCRIPTION:
*   This program implements a simple Hangman game in Java. It allows one user
*   to enter a secret word while another user attempts to guess the word by
*   guessing individual letters or the entire word. The game provides visual 
*   feedback using ASCII art, and the player has a limited 5 incorrect 
*   attempts before the game ends.
*
* FEATURES:
*   - A secret word is entered by one player.
*   - Another player attempts to guess the word by entering letters.
*   - The game provides feedback on correct and incorrect guesses.
*   - ASCII art is displayed progressively as the player makes incorrect guesses.
*   - The game ends when the player correctly guesses the word or reaches the 
*     maximum number of incorrect guesses.
*
* COMPATIBILITY:
*   - Designed to work with older Java versions (no Java 14+ features required).
*   - Uses standard Java syntax to ensure compatibility with Unix-based systems.
*
* COMPILATION AND EXECUTION:
*   1. Compile: javac Hangman_v3_final_fixed.java
*   2. Run: java Hangman_v3_final_fixed
*
* AUTHOR: Bilal Alissa 200384288
*/

import java.util.Scanner;

public class Hangman_v3_final_fixed {
    private static final int MAX_ATTEMPTS = 5; // Maximum incorrect guesses
    private String secretWord;
    private StringBuilder guessedWord;
    private int incorrectGuesses;
    private boolean gameOver;

    public Hangman_v3_final_fixed(String word) {
        this.secretWord = word.toUpperCase();
        this.guessedWord = new StringBuilder("*".repeat(secretWord.length()));
        this.incorrectGuesses = 0;
        this.gameOver = false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printHangman_v3_final_fixed(); // Draw the current Hangman_v3_final_fixed state
            System.out.println("\nCurrent Word: " + guessedWord);
            System.out.println("Incorrect Guesses: " + incorrectGuesses + "/" + MAX_ATTEMPTS);
            System.out.print("Enter a letter or guess the word: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1) {
                processLetterGuess(input.charAt(0));
            } else {
                processWordGuess(input);
            }

            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("\n\t🎉 Congratulations! You guessed the word: " + secretWord + "\n");
                gameOver = true;
            }

            if (incorrectGuesses >= MAX_ATTEMPTS) {
                printHangman_v3_final_fixed(); // Final Hangman_v3_final_fixed drawing
                System.out.println("\n\t💀 Game Over! The correct word was: " + secretWord + "\n");
                gameOver = true;
            }
        }
        scanner.close();
    }

    private void processLetterGuess(char letter) {
        if (guessedWord.indexOf(String.valueOf(letter)) != -1) {
            System.out.println("⚠️ You already guessed this letter.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedWord.setCharAt(i, letter);
                found = true;
            }
        }

        if (!found) {
            incorrectGuesses++;
            System.out.println("❌ Incorrect guess!");
        }
    }

    private void processWordGuess(String wordGuess) {
        if (wordGuess.equals(secretWord)) {
            guessedWord = new StringBuilder(secretWord);
        } else {
            System.out.println("❌ Incorrect word guess!");
            incorrectGuesses = MAX_ATTEMPTS;
        }
    }

    private void printHangman_v3_final_fixed() {
        System.out.println("\nHangman STATUS:");
        switch (incorrectGuesses) {
            case 0:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case 1:
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 2:
                System.out.println(" -----");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 3:
                System.out.println(" -----");
                System.out.println(" |   O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 4:
                System.out.println(" -----");
                System.out.println(" |   O");
                System.out.println(" |   |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 5:
                System.out.println(" -----");
                System.out.println(" |   O");
                System.out.println(" |  /|\\\\");
                System.out.println(" |  / \\\\");
                System.out.println(" |");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\n\t🎮 Welcome to Hangman Game!\n");
        System.out.print("\nEnter the secret word: ");
        String secretWord = scanner.nextLine();
        Hangman_v3_final_fixed game = new Hangman_v3_final_fixed(secretWord);
        game.playGame();
        scanner.close();
    }
}
