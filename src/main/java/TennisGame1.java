import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private final String player1Name;
    private final String player2Name;
    private final int b_match_score = 2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name)) {
            m_score1++;
        } else {
            m_score2++;
        }
    }

    public String getScore() {
        String[] scoreResults = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        int diffScore = getDiffScore();
        if (isAll()) {
            return scoreResults[m_score1] + "-" + "All";
        }

        if (isDeuce()) {
            return "Deuce";
        }

        if (isMinus() && (isAdvantage(diffScore))) {
            return "Advantage %s".formatted(getAnnounceNamePlayer(diffScore));
        }

        if (isMinus() && isWin(diffScore)) {
            return "Win for %s".formatted(getAnnounceNamePlayer(diffScore));
        }

        return scoreResults[m_score1] + "-" + scoreResults[m_score2];
    }

    private boolean isWin(int diffScore) {
        return Math.abs(diffScore) >= 2;
    }

    private boolean isAdvantage(int minusResult) {
        int differentAdvantageScore = 1;
        return Math.abs(minusResult) == differentAdvantageScore;
    }

    private String getAnnounceNamePlayer(int minusResult) {
        int b_win = 0;
        return minusResult <= b_win ? this.player2Name : this.player1Name;
    }

    private int getDiffScore() {
        return m_score1 - m_score2;
    }

    private boolean isMinus() {
        int m_match_score = 4;
        return m_score1 >= m_match_score || m_score2 >= m_match_score;
    }

    private boolean isDeuce() {
        return m_score1 == m_score2 && m_score1 > b_match_score;
    }

    private boolean isAll() {
        return m_score1 == m_score2 && m_score1 <= b_match_score;
    }
}