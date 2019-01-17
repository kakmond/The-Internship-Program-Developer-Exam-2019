package main;

import game.HangmanGame;
import ui.ConsoleUI;

public class Main {
	public static void main(String[] args) {
		HangmanGame game = new HangmanGame();
		ConsoleUI console = new ConsoleUI(game);
		console.play();
	}
}
