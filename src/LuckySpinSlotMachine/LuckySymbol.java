package luckyspinslotmachine;

import luckyspinslotmachine.Symbol;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

public class LuckySymbol extends Symbol {
    private int bonus;

    public LuckySymbol(String icon, int value, int bonus) {
        super(icon, value);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

