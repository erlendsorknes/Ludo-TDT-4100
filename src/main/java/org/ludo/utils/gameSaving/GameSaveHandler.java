package org.ludo.utils.gameSaving;

import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GameSaveHandler implements FileHandler {

	private String getDirPath() {
		return String.valueOf(Paths.get("src", "main", "resources", "org", "ludo", "assets", "saveFiles"));
	}

	private String getFilePath(String filename) {
		return getDirPath() + "/" + filename;
	}


	private int numSavedGames() {
		return Objects.requireNonNull(new File(getDirPath()).list()).length;
	}

	public ArrayList<String> getSavedGames() {
		return new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(getDirPath()).list())));
	}

	@Override
	public void saveGame(String content) {
		try {
			String filename = "gamesave#" + (numSavedGames() + 1) + ".json";
			FileWriter myWriter = new FileWriter(getFilePath(filename));

			myWriter.write(content);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			System.out.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public SerializedGameState loadGameSave(String filename) throws IOException {
		String content = Files.lines(Paths.get("src", "main", "resources", "org", "ludo", "assets", "saveFiles", filename)).collect(Collectors.toList()).get(0);
		Type type = new TypeToken<SerializedGameState>() {
		}.getType();

		return Serializer.deserialize(content, type);
	}
}