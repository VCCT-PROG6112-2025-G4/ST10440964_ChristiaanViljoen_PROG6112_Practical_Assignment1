package luckyspinslotmachine;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

import luckyspinslotmachine.LuckySymbol;
import java.util.Random;
import luckyspinslotmachine.Symbol;

public class SlotMachine {
    private Symbol[] symbols;
    private Random random;

    public SlotMachine() {
        symbols = new Symbol[] {
            new Symbol("Cheryy", 5),
            new Symbol("Lemon", 10),
            new Symbol("Bell", 10),
            new Symbol("Star", 20),
            new LuckySymbol("7", 100, 50)
        };
        random = new Random();
    }

    // 3x3 grid of symbols
    public Symbol[][] spin() {
        Symbol[][] grid = new Symbol[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                grid[row][col] = symbols[random.nextInt(symbols.length)];
            }
        }
        return grid;
    }

    // Payout for each row in the 3x3 grid
    public int checkPayout(Symbol[][] grid) {
        int totalPayout = -20; //cost of spin

        for (int row = 0; row < 3; row++) {
            Symbol a = grid[row][0];
            Symbol b = grid[row][1];
            Symbol c = grid[row][2];

            if (a.getIcon().equals(b.getIcon()) && b.getIcon().equals(c.getIcon())) {
                int base = a.getValue() * 5;
                if (a instanceof LuckySymbol) {
                    base += ((LuckySymbol) a).getBonus();
                }
                totalPayout += base;
            } else if (a.getIcon().equals(b.getIcon()) ||
                       b.getIcon().equals(c.getIcon()) ||
                       a.getIcon().equals(c.getIcon())) {
                totalPayout += 20;
            }
        }
        return totalPayout;
    }

    public void printGrid(Symbol[][] grid) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col].getIcon() + " ");
            }
            System.out.println();
        }
    }
}

