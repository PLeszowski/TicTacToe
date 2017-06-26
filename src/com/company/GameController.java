package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameController {

	static final int P1 = 1;
	static final int P2 = 10;
	public static int TOTAL_MOVES = Game.LEN * Game.LEN;
	private int currentPlayer = P2;

	private Game game;
	private Printer printer;
	private Scanner sc;

	public GameController() {
		game = new Game();
		printer = new Printer();
		sc = new Scanner(System.in);
	}

	public void playGame() {

		int count = 0;

		do {
			count++;
			currentPlayer = switchPlayer(currentPlayer);
			playerPlay(currentPlayer);

		} while (game.isDone() == 0 && count < TOTAL_MOVES);

		printer.print(game.getGameMap());

		if(count < TOTAL_MOVES) {
			System.out.println("Player " + printer.getSymbol(currentPlayer) + " YOU WIN!");
		}
		else {
			System.out.println("Its a tie");
		}
	}

	private void playerPlay(int player) {

		int x, y;
		int value;
		int[] coordinates;

		printer.print(game.getGameMap());

		do {
			System.out.println("Player " + printer.getSymbol(player) + " choose spot");

			do {
				try {
					value = sc.nextInt();
				} catch (InputMismatchException e) {
					value = 0;
					sc.next();
				}

				if (value < 1 || value > TOTAL_MOVES) {
					System.out.println("Please enter value between 1 and " + TOTAL_MOVES);
					value = 0;
				}

			} while (value < 1 || value > TOTAL_MOVES);

			coordinates = getCoordinates(value);

			x = coordinates[0];
			y = coordinates[1];

		} while (!game.makeMove(x, y, player));
	}

	private int[] getCoordinates(int val) {

		int[] coordinates = new int[2];
		int x, y;

		y = (val - 1) / Game.LEN;
		x = (val - 1) % Game.LEN;

		coordinates[0] = x;
		coordinates[1] = y;

		return coordinates;
	}

	private int switchPlayer (int player){

		if (player == P1) {
			player = P2;
		} else {
			player = P1;
		}

		return player;
	}

}