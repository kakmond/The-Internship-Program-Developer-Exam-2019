import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HangmanGame {

	private final String WORDS_DIRECTORY = "./src/words/";
	private List<String> types = new ArrayList<>();
	private List<Word> words = new ArrayList<>();
	private Word currentWord;
	private Reader reader;
	private int score;
	private int life;
	private List<Character> wrongGuess = new ArrayList<>();

	public HangmanGame() {
		life = 10;
		reader = new Reader();
		types = reader.readFilesName(WORDS_DIRECTORY);
	}

	public void selectType(int index) {
		List<Word> words = reader.readWord(WORDS_DIRECTORY + types.get(index) + ".csv");
		Collections.shuffle(words); // random words
		this.words = words;
		currentWord = words.get(0);
	}

	public void guess(char alphabet) {
		if (currentWord.getDisplay().toLowerCase().indexOf(Character.toLowerCase(alphabet)) == -1) {
			if (currentWord.isContain(alphabet)) {
				score += 15;
			} else {
				life -= 1;
				wrongGuess.add(alphabet);
			}
		}
	}

	public int getScore() {
		return this.score;
	}

	public int getLife() {
		return this.life;
	}

	public List<Character> getWrongGuess() {
		return this.wrongGuess;
	}

	public String getHint() {
		return currentWord.getHint();
	}

	public String getDisplay() {
		return this.currentWord.getDisplay();
	}

	public List<String> getTypes() {
		return this.types;
	}

	public boolean isWordCompleted() {
		return this.currentWord.getDisplay().equalsIgnoreCase(this.currentWord.getWord());
	}

	public void nextWord() {
		words.remove(0);
		if (words.size() > 0)
			currentWord = words.get(0);
	}

	public boolean isEnded() {
		return this.isWon() || this.isGameOver();
	}

	public boolean isWon() {
		return this.words.size() <= 0;
	}

	public boolean isGameOver() {
		return this.life < 0;
	}

}
