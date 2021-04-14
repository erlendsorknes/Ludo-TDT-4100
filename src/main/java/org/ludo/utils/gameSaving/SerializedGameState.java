package org.ludo.utils.gameSaving;

import java.util.ArrayList;
import java.util.Arrays;

public class SerializedGameState {
	private int currentPlayerTurn;
	private int currentTurnTries;
	private SerializedPlayer[] players;

	public int getCurrentPlayerTurn() {
		return currentPlayerTurn;
	}

	public int getCurrentTurnTries() {
		return currentTurnTries;
	}

	public ArrayList<SerializedPlayer> getPlayers() {
		return new ArrayList<>(Arrays.asList(players));
	}

	@Override
	public String toString() {
		return "SerializedGameState{" +
				"currentPlayerTurn=" + currentPlayerTurn +
				", currentTurnTries=" + currentTurnTries +
				", players=" + Arrays.toString(players) +
				'}';
	}
}
