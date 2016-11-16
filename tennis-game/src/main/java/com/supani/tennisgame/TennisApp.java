package com.supani.tennisgame;

import javax.swing.JOptionPane;

public class TennisApp {

	public static void main(String[] args) {

		TennisGame tg = new TennisGame();
		String player = "";

		while (true) {
			/*Scanner in = new Scanner(System.in);
			System.out.println("Enter the player Name");
			player = in.nextLine();
			tg.wonPoint(player);
			System.out.println("Score : "+tg.getScore());*/
			
			player = JOptionPane.showInputDialog("Please enter the player name: ");
			if (player != null) {
				tg.getGamePoint(player);
				if (!tg.getGameScore().equalsIgnoreCase("Player1 Won")
						&& !tg.getGameScore().equalsIgnoreCase("Player2 Won")) {
					JOptionPane.showMessageDialog(null, "Score : " + tg.getGameScore());
				} else if (tg.getGameScore().equalsIgnoreCase("Player1 Won")
						|| tg.getGameScore().equalsIgnoreCase("Player2 Won")) {
					JOptionPane.showMessageDialog(null, player + " Won!!");
					break;
				}
			} else
				break;
		}

	}

}
