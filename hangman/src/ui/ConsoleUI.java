package ui;

import java.util.List;
import java.util.Scanner;

import game.HangmanGame;

public class ConsoleUI {

	private Scanner scanner;
	private HangmanGame game;

	public ConsoleUI(HangmanGame game) {
		this.scanner = new Scanner(System.in);
		this.game = game;
	}

	public void play() {
		System.out.println("Select Category:");
		printTypes(game.getTypes());
		int choice = prompt(">") - '0'; // parse to integer
		game.selectType(choice - 1);
		System.out.println(game.getHint());
		while (!game.isEnded()) {
			printStatus();
			char guess = prompt(">");
			game.guess(guess);
			if (game.isWon()) {
				printStatus();
				System.out.println("Congratulations you are a winner!");
			} else if (game.isGameOver()) {
				System.out.println("Game over!");
			} else if (game.isWordCompleted()) {
				game.nextWord();
				System.out.println(game.getHint());
			}
		}
	}

	private void printStatus() {
		printDisplay(game.getDisplay());
		System.out.print("Score: " + game.getScore());
		System.out.print(", Remaining wrong guess: " + game.getLife());
		if (game.getWrongGuess().size() > 0) {
			System.out.print(", Wrong guessed: ");
			for (Character alphabet : game.getWrongGuess()) {
				System.out.print(alphabet + " ");
			}
		}
		System.out.println();
	}

	private void printDisplay(String display) {
		for (int i = 0; i < display.length(); i++) {
			System.out.print(display.charAt(i) + " ");
		}
	}

	private char prompt(String msg) {
		System.out.print(msg + " ");
		return scanner.next().trim().charAt(0);
	}

	private void printTypes(List<String> types) {
		for (String type : types) {
			System.out.println(type);
		}
	}

}
