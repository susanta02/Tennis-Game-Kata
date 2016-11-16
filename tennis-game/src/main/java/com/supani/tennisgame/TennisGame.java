package com.supani.tennisgame;

import javax.swing.JOptionPane;

public class TennisGame{

	private int player1_point = 0;
	private int player2_point = 0;
	private String player1;
    private String player2;
    
	public TennisGame() {
	}
	
	public TennisGame(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void getGamePoint(String player) {
		if (player.equals("player1"))
			player1_point += 1;
		else if (player.equalsIgnoreCase("player2"))
			player2_point += 1;
		else
			JOptionPane.showMessageDialog(null, "Please enter a valid player name!");
	}
	
	public String getGameScore() {
		String score = "";
		int scoreVal = 0;
		if (player1_point == player2_point) {
			switch (player1_point) {
			case 0:
				score = "Love-All";
				break;
			case 1:
				score = "Fifteen-All";
				break;
			case 2:
				score = "Thirty-All";
				break;
			default:
				score = "Deuce";
				break;

			}
		} else if (player1_point >= 4 || player2_point >= 4) {
			int pointDiff = player1_point - player2_point;
			if (pointDiff == 1)
				score = "Advantage Player1";
			else if (pointDiff == -1)
				score = "Advantage Player2";
			else if (pointDiff >= 2)
				score = "Player1 Won";
			else
				score = "Player2 Won";
		} else {
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					scoreVal = player1_point;
				else {
					score += "-";
					scoreVal = player2_point;
				}
				switch (scoreVal) {
				case 0:
					score += "Love";
					break;
				case 1:
					score += "Fifteen";
					break;
				case 2:
					score += "Thirty";
					break;
				case 3:
					score += "Forty";
					break;
				}
			}
		}
		return score;
	}
}
