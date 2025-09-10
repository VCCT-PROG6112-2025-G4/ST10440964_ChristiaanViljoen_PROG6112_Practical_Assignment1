package luckyspinslotmachine;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

public class Player {
    private String name;
    private int balance;
    private int wins;
    private int losses;

    // Constructor
    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.wins = 0;
        this.losses = 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWins() {
        return wins;
    }

    public void addWin() {
        this.wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void addLoss() {
        this.losses++;
    }
}

