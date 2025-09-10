package luckyspinslotmachine;

/**
 *
 * @author Christiaan Viljoen ST10440964
 */

public class Symbol {
    private String icon;
    private int value;   

    public Symbol(String icon, int value) {
        this.icon = icon;
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public int getValue() {
        return value;
    }
}

