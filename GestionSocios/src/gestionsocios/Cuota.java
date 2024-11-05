package gestionsocios;

/**
 *
 * @author Rafael
 */
public class Cuota {
    private int amount;

    public Cuota(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Monto cancelado: $" + amount;
    }
}