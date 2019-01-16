
public class Word {

	private String word;
	private String hint;
	private String display = "";

	public Word(String word, String hint) {
		this.word = word.replaceAll(" ", ""); // remove space
		this.hint = hint;
		for (int i = 0; i < this.word.length(); i++)
			display += "_";
	}

	public boolean isContain(char alphabet) {
		boolean isMatched = false;
		for (int i = 0; i < word.length(); i++)
			if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(alphabet)) {
				display = replaceString(display, i, word.charAt(i));
				isMatched = true;
			}
		if (isMatched)
			return true;
		else
			return false;
	}

	public String getWord() {
		return this.word;
	}

	public String getDisplay() {
		return this.display;
	}

	public String getHint() {
		return this.hint;
	}

	private String replaceString(String str, int index, char replace) {
		if (str == null)
			return str;
		else if (index < 0 || index >= str.length())
			return str;
		char[] chars = str.toCharArray();
		chars[index] = replace;
		return String.valueOf(chars);
	}

}
