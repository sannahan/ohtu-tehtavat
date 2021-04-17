package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private static final int zeroPoints = 0,
                onePoint = 1, 
                twoPoints = 2, 
                threePoints = 3, 
                closeToWinning = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        
        if (m_score1 == m_score2) {
            score = getScoreName(m_score1) + "-All";
            if (score.contains("Deuce")) {
                score = "Deuce";
            }
        } else if (m_score1 >= closeToWinning || m_score2 >= closeToWinning) {
            score = getGameStatus(m_score1, m_score2);
        } else {
            score = getScoreName(m_score1) + "-" + getScoreName(m_score2);
        }
        
        return score;
    }
    
    private String getScoreName(int score) {
        String scoreAsString = "";
        switch(score) {
            case zeroPoints:
                scoreAsString = "Love";
                break;
            case onePoint:
                scoreAsString = "Fifteen";
                break;
            case twoPoints:
                scoreAsString = "Thirty";
                break;
            case threePoints:
                scoreAsString = "Forty";
                break;
            default:
                scoreAsString = "Deuce";
        }
        return scoreAsString;
    }
    
    private String getGameStatus(int score1, int score2) {
        String score = "";
        if (Math.abs(score1 - score2) == 1) {
                score += "Advantage player";
            } else {
                score += "Win for player";
            }
            if (score1 > score2) {
                score += "1";
            } else {
                score += "2";
        }
        return score;
    }
}