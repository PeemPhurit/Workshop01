import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private int minusTimeScore = 4;
    private final String player1Name;
    private final String player2Name;

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
        if (isAll()) {
            return scoreResults[m_score1] + "-" + "All";
        }

        if (isDeuce()) {
            return "Deuce";
        }

        if (isMinus()) {
            int minusResult = getMinusResult();
            if (isAdvantage(minusResult)) return "Advantage %s".formatted(getAnnounceNamePlayer(minusResult));
            else return "Win for %s".formatted(getAnnounceNamePlayer(minusResult));
        }
        return scoreResults[m_score1] + "-" + scoreResults[m_score2];
    }

    private boolean isAdvantage(int minusResult) {
        return Math.abs(minusResult) == 1;
    }

    private String getAnnounceNamePlayer(int minusResult) {
        return minusResult <= 0 ? this.player2Name : this.player1Name;
    }

    private int getMinusResult() {
        return m_score1 - m_score2;
    }

    private boolean isMinus() {
        return m_score1 >= minusTimeScore || m_score2 >= minusTimeScore;
    }

    private boolean isDeuce() {
        return m_score1 == m_score2 && m_score1 > 2;
    }

    private boolean isAll() {
        return m_score1 == m_score2 && m_score1 <= 2;
    }
}