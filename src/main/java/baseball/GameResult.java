package baseball;

import java.util.Objects;

public class GameResult {
    private static final int DEFAULT_SCORE = 0;
    private int strike;
    private int ball;

    public GameResult() {
        this(DEFAULT_SCORE, DEFAULT_SCORE);
    }

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
    
    public void addResult(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }
        if (status.isBall()) {
            ball++;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameResult that = (GameResult) obj;
        return strike == that.strike && ball == that.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
