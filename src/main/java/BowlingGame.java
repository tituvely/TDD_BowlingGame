public class BowlingGame {
    private int[] score = new int[21];
    private int currentRole;

    public int getScore() {
        int total = 0;

        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if(isStrike(frameIndex)) {
                total += 10 + getStrikeBonus(frameIndex);
                frameIndex += 1;
            }
            else if(isSpare(frameIndex)) {
                total += 10 + getSpareBonus(frameIndex);
                frameIndex += 2;
            } else {
                total += score[frameIndex] + score[frameIndex + 1];
                frameIndex += 2;
            }
        }

        return total;
    }

    private boolean isStrike(int frameIndex) {
        return score[frameIndex] == 10;
    }

    private int getStrikeBonus(int frameIndex) {
        return score[frameIndex + 1] + score[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return score[frameIndex] + score[frameIndex + 1] == 10;
    }

    private int getSpareBonus(int frameIndex) {
        return score[frameIndex + 2];
    }

    public void roll(int pins) {
        score[currentRole++] = pins;
    }

}
