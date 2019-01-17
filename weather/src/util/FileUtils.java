package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtils {

	public static String readFile(File file) {
		StringBuilder content = new StringBuilder();
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				content.append(line);
				content.append(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			System.out.println(file.getAbsolutePath() + " was not found.");
		} finally {
			scan.close();
		}
		return content.toString();
	}

	public static void writeFile(String path, String content) {
		try (PrintWriter out = new PrintWriter(path)) {
			out.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
