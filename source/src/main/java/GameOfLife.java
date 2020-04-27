import java.util.Random;

import static java.lang.String.valueOf;
import static java.lang.Thread.sleep;

public class GameOfLife {
    private int vertical, horizontal;
    private int [] [] [] generation;

    GameOfLife(int vertical, int horizontal, int generations) {
        this.setSize(vertical, horizontal, generations);
        this.setupGame();
    }

    private void setupGame() {
        Random random = new Random();
        int t = 0;
        for(int x = 0; x < vertical; x++) {
            for(int y = 0; y < horizontal; y++) {
                generation[x][y][t] = random.nextInt(2);
            }
        }
    }

    void runGame(int generation) throws InterruptedException {
        showGame(generation);
        validateRules(generation);
        sleep(10000);
    }

    private void validateRules(int t) {
        for (int x = 0; x < vertical; x++) {
            for (int y = 0; y < horizontal; y++) {
                int neighbors = 0;
                for (int h = x - 1; h <= x + 1; h++) {
                    if (!inboundsVertical(h)) { continue; }
                    for (int v = y - 1; v <= y + 1; v++) {
                        if (!inboundsHorizontal(v)) { continue; }
                        if(generation[h][v][t] == 1) { neighbors++; }
                    }
                }
                neighbors -= generation[x][y][t];
                generation[x][y][t+1] = (neighbors < 2 || neighbors > 3) ? 0 : (neighbors == 3) ? 1 : generation[x][y][t];
            }
        }
    }

    public void showGame(int t) {
        for (int x = 0; x < vertical; x++) {
            for (int y = 0; y < horizontal; y++) {
                int element = generation[x][y][t];
                System.out.print(element + "  ");
            }
            System.out.println();
        }
    }

    private void setSize(int vertical, int horizontal, int generations) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        generation = new int [vertical] [horizontal] [generations];
    }

    private boolean inboundsVertical(int index){
        return (index >= 0) && (index < vertical);
    }

    private boolean inboundsHorizontal(int index){
        return (index >= 0) && (index < horizontal);
    }
}
