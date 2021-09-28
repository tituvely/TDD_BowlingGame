import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void gutterGame() {
        rollMany(0, 20);
        // Verify
        Assertions.assertEquals(0, bowlingGame.getScore());
    }

    @Test
    public void allOnes() {
        rollMany(1, 20);
        Assertions.assertEquals(20, bowlingGame.getScore());
    }

    @Test
    public void oneSpare() {
        bowlingGame.roll(4);
        bowlingGame.roll(6);
        bowlingGame.roll(3);
        rollMany(0, 17);

        Assertions.assertEquals(16, bowlingGame.getScore());
    }

    @Test
    public void oneStrike() {
        bowlingGame.roll(10);
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        rollMany(0, 16);

        Assertions.assertEquals(26, bowlingGame.getScore());
    }

    @Test
    public void perfectGame() {
        rollMany(10, 12);
        Assertions.assertEquals(300, bowlingGame.getScore());
    }

    private void rollMany(int pins, int count) {
        for (int i = 0; i < count; i++) {
            bowlingGame.roll(pins);
        }
    }

}
