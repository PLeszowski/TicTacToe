package com.company;


import java.util.Scanner;

/**
 * Created by RENT on 2017-06-22.
 */
public class GameController {

	public static final int P1 = 1;
	public static final int P2 = 10;
	private int currentPlayer = P1;
	Game game;

	public GameController() {
		game = new Game();
	}

	public void playGame(){



		while (game.isDone() == 0){

		playerPlay(currentPlayer);

			if (currentPlayer == P1){
				currentPlayer = P2;
			} else {
				currentPlayer = P1;
			}

		}

	}

	public void playerPlay (int player){

		Scanner sc = new Scanner(System.in);
		Printer printer = new Printer();
		int x,y;

		printer.print(game.getGameMap());

		do {
			System.out.println("Player " + printer.getSymbol(player)+ " choose spot x coordinate");
			x = sc.nextInt();
			System.out.println("Player " + printer.getSymbol(player)+ " choose spot y coordinate");
			y = sc.nextInt();
		} while(!game.makeMove(x,y,player));

	}

}
