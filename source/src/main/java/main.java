import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InterruptedException {
//        JFrame gui = new JFrame("GameOfLifeGUI");
//        gui.setContentPane(new GameOfLifeGUI().panel);
//        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gui.pack();
//        gui.setVisible(true);

        Scanner in = new Scanner(System.in);
        System.out.println("Vertical: ");
        int v = in.nextInt();
        System.out.println("Horizontal: ");
        int h = in.nextInt();
        System.out.println("Generations to calculate: ");
        int g = in.nextInt();

        GameOfLife gameOfLife = new GameOfLife(v, h, g);
        for (int y = 0; y < g-1; y++) {
            System.out.println();
            System.out.println("GENERATION " + y);
            gameOfLife.runGame(y);
        }
        System.out.println();
        System.out.println("GENERATION " + (g-1));
        gameOfLife.showGame(g-1);
    }
}
