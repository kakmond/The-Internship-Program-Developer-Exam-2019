
public class Main {
	public static void main(String[] args) {
		HangmanGame game = new HangmanGame();
		ConsoleUI console = new ConsoleUI(game);
		console.play();
	}
}
