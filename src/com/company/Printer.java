package com.company;

/**
 * Created by zz9ffd on 2017-06-23.
 */
public class Printer {

	public void print(int gameMap[][]){

		int count = 0;
		int val;

		System.out.print("\n\n");

		for(int j = 0; j < Game.LEN ; j++){

			for(int i = 0; i < Game.LEN; i++){

				count++;
				val = gameMap[i][j];

				if(val == GameController.P1 || val == GameController.P2) {
					System.out.print(getSymbol(val));
				}
				else {
					System.out.print(count);
				}

				if(i < Game.LEN - 1){
					System.out.print("|");
				} else {
					System.out.print("\n");
				}
			}

			if(j < Game.LEN - 1) {
				for(int i = 0; i < (Game.LEN * 2) - 1; i++) {
					System.out.print("-");
				}
				System.out.print("\n");
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
