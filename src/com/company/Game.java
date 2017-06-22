package com.company;

/**
 * Created by RENT on 2017-06-22.
 */
public class Game {

	private int player;
	private int [][] gameMap;
	public static final int LEN = 3;

	public Game() {
		gameMap = new int [LEN][LEN];
		setGameMap();
	}

	private void setGameMap (){

		for(int i = 0; i < LEN; i++){
			for(int j = 0; j < LEN; j++){
				gameMap[i][j] = 0;
			}
		}
	}

	public boolean makeMove (int x, int y, int player){

		this.player = player;
		if(x > LEN-1 || y > LEN-1){
			return false;
		}
		if(gameMap[x][y] != 0){
			return false;
		}
		gameMap[x][y] = player;
		return true;

	}

	public int isDone(){

		int score = 0;
		// Check vertical ---------------------
		for(int i = 0; i < LEN; i++){
			for(int j = 0; j < LEN; j++){
				score = score + gameMap[i][j];
				}
			}
        if(score == GameController.P1 * Game.LEN)
			return GameController.P1;
		if(score == GameController.P2 * Game.LEN)
			return GameController.P2;

		// Check horizontal ---------------------
		for(int j = 0; j < LEN; j++){
			for(int i = 0; i < LEN; i++){
				score = score + gameMap[i][j];
			}
		}
		if(score == GameController.P1 * Game.LEN)
			return GameController.P1;
		if(score == GameController.P2 * Game.LEN)
			return GameController.P2;

		// Check diagonal left to right ----------
		for(int i = 0; i < LEN; i++){
			score = score + gameMap[i][i];
		}
		if(score == GameController.P1 * Game.LEN)
			return GameController.P1;
		if(score == GameController.P2 * Game.LEN)
			return GameController.P2;

		// Check diagonal right to left ----------
		for(int i = LEN-1; i >= 0; i--){
			score = score + gameMap[i][i];
		}
		if(score == GameController.P1 * Game.LEN)
			return GameController.P1;
		if(score == GameController.P2 * Game.LEN)
			return GameController.P2;

		return 0;
	}

	public int getPlayer() {
		return player;
	}

	public int[][] getGameMap() {
		return gameMap;
	}

}
