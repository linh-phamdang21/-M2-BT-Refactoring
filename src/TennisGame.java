public class TennisGame {
    public static final String SCORE_0 = "Love-All";
    public static final String SCORE_1 = "Fifteen-All";
    public static final String SCORE_2 = "Thirty-All";
    public static final String SCORE_3 = "Forty-All";
    public static final String SCORE_DEUCE = "Deuce";
    public static final String PLAYER1_ADVANTAGE = "Advantage player 1";
    public static final String PLAYER2_ADVANTAGE = "Advantage player 2";
    public static final String PLAYER1_WIN = "Win for Player 1";
    public static final String PLAYER2_WIN = "Win for Player 2";
    public static final String TEMP_SCORE_0 = "Love";
    public static final String TEMP_SCORE_1 = "Fifteen";
    public static final String TEMP_SCORE_2 = "Thirty";
    public static final String TEMP_SCORE_3 = "Fourty";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore=0;
        if (player1Score==player2Score)
        {
            switch (player1Score)
            {
                case 0:
                    score = SCORE_0;
                    break;
                case 1:
                    score = SCORE_1;
                    break;
                case 2:
                    score = SCORE_2;
                    break;
                case 3:
                    score = SCORE_3;
                    break;
                default:
                    score = SCORE_DEUCE;
                    break;

            }
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            int minusResult = player1Score-player2Score;
            if (minusResult==1) score =PLAYER1_ADVANTAGE;
            else if (minusResult ==-1) score =PLAYER2_ADVANTAGE;
            else if (minusResult>=2) score = PLAYER1_WIN;
            else score = PLAYER2_WIN;
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = player1Score;
                else { score+="-"; tempScore = player2Score;}
                switch(tempScore)
                {
                    case 0:
                        score+= TEMP_SCORE_0;
                        break;
                    case 1:
                        score+= TEMP_SCORE_1;
                        break;
                    case 2:
                        score+= TEMP_SCORE_2;
                        break;
                    case 3:
                        score+= TEMP_SCORE_3;
                        break;
                }
            }
        }
        return score;
    }
}
