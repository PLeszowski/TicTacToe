package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by zz9ffd on 2017-06-23.
 */
public class GameController {

	public static final int P1 = 1;
	public static final int P2 = 10;
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

			if (currentPlayer == P1) {
				currentPlayer = P2;
			} else {
				currentPlayer = P1;
			}

			playerPlay(currentPlayer);

		} while (game.isDone() == 0 && count < TOTAL_MOVES);

		printer.print(game.getGameMap());

		if(count < TOTAL_MOVES)
			System.out.println("Player " + printer.getSymbol(currentPlayer) + " YOU WIN!");
		else
			System.out.println("Its a tie");
	}

	private void playerPlay(int player) {

		int x, y;
		int val;
		int[] coordinates;

		printer.print(game.getGameMap());

		do {
			System.out.println("Player " + printer.getSymbol(player) + " choose spot");

			do {
				try {
					val = sc.nextInt();
				} catch (InputMismatchException e) {
					val = 0;
					sc.next();
				}

				if (val < 1 || val > TOTAL_MOVES) {
					System.out.println("Please enter value between 1 and " + TOTAL_MOVES);
					val = 0;
				}

			} while (val < 1 || val > TOTAL_MOVES);

			coordinates = getCoordinates(val);

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

}