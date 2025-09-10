package luckyspinslotmachine;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

import java.util.Scanner;
import luckyspinslotmachine.Player;
import luckyspinslotmachine.SlotMachine;
import luckyspinslotmachine.Symbol;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        Player player = new Player(name, 100);

        SlotMachine slotMachine = new SlotMachine();

        System.out.println("Welcome to LuckySpinner Slot Machine, " + player.getName() + "!");
        boolean playing = true;

        while (playing && player.getBalance() > 0) {
            System.out.println("\nBalance: " + player.getBalance());
            System.out.print("Press ENTER to spin or type 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                playing = false;
                break;
            }

            Symbol[][] grid = slotMachine.spin();
            slotMachine.printGrid(grid);

            int payout = slotMachine.checkPayout(grid);
            if (payout > 0) {
                player.setBalance(player.getBalance() + payout);
                player.addWin();
                System.out.println("You WON! +" + payout + " credits 🎉");
            } else {
                player.setBalance(player.getBalance() + payout);
                player.addLoss();
                System.out.println("Sorry, you lost this round.");
            }
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Player: " + player.getName());
        System.out.println("Final Balance: " + player.getBalance());
        System.out.println("Total Wins: " + player.getWins());
        System.out.println("Total Losses: " + player.getLosses());
    }
}

