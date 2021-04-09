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
		return (ArrayList<SerializedPlayer>) Arrays.asList(players);
	}

}