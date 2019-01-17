package main;

import java.io.File;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import util.FileUtils;

public class Main {

	private static int PRETTY_PRINT_INDENT_FACTOR = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input your XML file path (ex: ./src/example/weather.xml): ");
		String path = scanner.next();
		File file = new File(path);
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(FileUtils.readFile(file));
			JSONObject currentJSONObj = xmlJSONObj.getJSONObject("current");
			String jsonPrettyPrintString = currentJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
			System.out.println("Result:\n" + jsonPrettyPrintString);
			String pathJSON = file.getParent() + "/" + file.getName().replace(".xml", ".json");
			System.out.println("**********************************************************");
			System.out.println("JSON file has been written to: " + pathJSON);
			FileUtils.writeFile(pathJSON, jsonPrettyPrintString);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}
	}

}
