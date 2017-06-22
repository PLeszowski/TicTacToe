package com.company;

/**
 * Created by RENT on 2017-06-22.
 */
public class Printer {

	public void print(int gameMap[][]){

		System.out.print("\n\n");

		for(int j = 0; j < Game.LEN ; j++){

			for(int i = 0; i < Game.LEN; i++){

				System.out.print(getSymbol(gameMap[i][j]));
				if(i < Game.LEN - 1){
					System.out.print("|");
				} else {
					System.out.print("\n");
				}
			}
			if(j < Game.LEN - 1) {
				System.out.print("-----\n");
			}

		}

		System.out.println("");
	}


	public char getSymbol(int symbol){

		if (symbol == GameController.P1){
			return 'X';
		}
		else if (symbol == GameController.P2){
			return 'O';
		}
		else {
			return ' ';
		}
	}



}
