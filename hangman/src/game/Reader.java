package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

	private final String DELIMITER = ",";

	public List<String> readFilesName(String directory) {
		List<String> files = new ArrayList<>();
		File folder = new File(directory);
		for (File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				String fileName = fileEntry.getName();
				files.add(fileName.substring(0, fileName.indexOf(".csv")));
			}
		}
		return files;
	}

	public List<Word> readWord(String path) {
		List<Word> words = new ArrayList<>();
		File file = new File(path);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			scan.nextLine(); // skip header
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] lineArray = line.split(DELIMITER);
				words.add(new Word(lineArray[0].trim(), lineArray[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		return words;
	}

}
