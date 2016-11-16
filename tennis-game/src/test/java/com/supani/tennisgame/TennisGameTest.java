package com.supani.tennisgame;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisGameTest {

    private int player1_point;
    private int player2_point;
    private String assertedScore;

    public TennisGameTest(int player1_point, int player2_point, String assertedScore) {
        this.player1_point = player1_point;
        this.player2_point = player2_point;
        this.assertedScore = assertedScore;
    }
    
    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },
                { 1, 1, "Fifteen-All" },
                { 2, 2, "Thirty-All"},
                { 3, 3, "Deuce"},
                { 4, 4, "Deuce"},
                
                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, "Player1 Won"},
                { 0, 4, "Player2 Won"},
                
                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, "Player1 Won"},
                { 1, 4, "Player2 Won"},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, "Player1 Won"},
                { 2, 4, "Player2 Won"},
                
                { 4, 3, "Advantage Player1"},
                { 3, 4, "Advantage Player2"},
                { 5, 4, "Advantage Player1"},
                { 4, 5, "Advantage Player2"},
                { 15, 14, "Advantage Player1"},
                { 14, 15, "Advantage Player2"},

                { 6, 4, "Player1 Won"},
                { 4, 6, "Player2 Won"},
                { 16, 14, "Player1 Won"},
                { 14, 16, "Player2 Won"},
        });
    }

    public void testGameScore(TennisGame game) {
        int highestScore = Math.max(this.player1_point, this.player2_point);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1_point)
                game.getGamePoint("player1");
            if (i < this.player2_point)
                game.getGamePoint("player2");
        }
        assertEquals(this.assertedScore, game.getGameScore());
    }

    @Test
    public void testTennisGamePlayersScore() {
        TennisGame tg = new TennisGame("player1", "player2");
        testGameScore(tg);
    }

}
