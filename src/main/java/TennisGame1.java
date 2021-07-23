import java.util.Objects;

public class TennisGame1 {
    private int m_score1 = 0;
    private int m_score2 = 0;
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
        int winSet = 4;
        // All
        if (isAll()) {
            return scoreResults[m_score1] + "-" + "All";
        }

        // Deuce
        if (isDeuce()) {
            // Deuce
            return "Deuce";
        }

        // ???? Advantage and Win ????
        if (m_score1 >= winSet || m_score2 >= winSet) {
            StringBuilder score = new StringBuilder();
            int minusResult = m_score1 - m_score2;
            if (minusResult == 1) score = new StringBuilder("Advantage ").append(this.player1Name);
            else if (minusResult == -1) score = new StringBuilder("Advantage ").append(this.player2Name);
            else if (minusResult >= 2) score = new StringBuilder("Win for ").append(this.player1Name);
            else score = new StringBuilder("Win for ").append(this.player2Name);
            return score.toString();
        }

        // Normal game
        return scoreResults[m_score1] + "-" + scoreResults[m_score2];
    }

    private boolean isDeuce() {
        return m_score1 == m_score2 && m_score1 > 2;
    }

    private boolean isAll() {
        return m_score1 == m_score2 && m_score1 <= 2;
    }
}