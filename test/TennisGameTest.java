import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TennisGameTest {
    public static final String SCORE_0 = "Love-All";
    public static final String SCORE_1 = "Fifteen-All";
    public static final String SCORE_2 = "Thirty-All";
    public static final String SCORE_3 = "Forty-All";
    public static final String SCORE_DEUCE = "Deuce";
    public static final String PLAYER1_ADVANTAGE = "Advantage player 1";
    public static final String PLAYER2_ADVANTAGE = "Advantage player 2";
    public static final String PLAYER1_WIN = "Win for Player 1";
    public static final String PLAYER2_WIN = "Win for Player 2";
    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisGameTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, SCORE_0 },
                { 1, 1, SCORE_1 },
                { 2, 2, SCORE_2},
                { 3, 3, SCORE_3},
                { 4, 4, SCORE_DEUCE},

                { 1, 0, "Fifteen-Love"},
                { 0, 1, "Love-Fifteen"},
                { 2, 0, "Thirty-Love"},
                { 0, 2, "Love-Thirty"},
                { 3, 0, "Forty-Love"},
                { 0, 3, "Love-Forty"},
                { 4, 0, PLAYER1_WIN},
                { 0, 4, PLAYER2_WIN},

                { 2, 1, "Thirty-Fifteen"},
                { 1, 2, "Fifteen-Thirty"},
                { 3, 1, "Forty-Fifteen"},
                { 1, 3, "Fifteen-Forty"},
                { 4, 1, PLAYER1_WIN},
                { 1, 4, PLAYER2_WIN},

                { 3, 2, "Forty-Thirty"},
                { 2, 3, "Thirty-Forty"},
                { 4, 2, PLAYER1_WIN},
                { 2, 4, PLAYER2_WIN},

                { 4, 3, PLAYER1_ADVANTAGE},
                { 3, 4, PLAYER2_ADVANTAGE},
                { 5, 4, PLAYER1_ADVANTAGE},
                { 4, 5, PLAYER2_ADVANTAGE},
                { 15, 14, PLAYER1_ADVANTAGE},
                { 14, 15, PLAYER2_ADVANTAGE},

                { 6, 4, PLAYER1_WIN},
                { 4, 6, PLAYER2_WIN},
                { 16, 14, PLAYER1_WIN},
                { 14, 16, PLAYER2_WIN},
        });
    }

    @Test
    public void checkAllScores() {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        int m_score1 = 0;
        int m_score2 = 0;
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                m_score1 += 1;
            if (i < this.player2Score)
                m_score2 += 1;
        }
        assertEquals(this.expectedScore, TennisGame.getScore("John", "Bill", m_score1, m_score2));
    }
}