import components.map.Map;
import components.map.Map1L;
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

public class Invoice {

    private Map<String, NaturalNumber> items;

    private boolean paid;

    public Invoice() {
        this.createNewRep();
    }

    public void createNewRep() {
        this.items = new Map1L<>();
        this.paid = false;
    }

    public boolean isPaid() {
        return this.paid;
    }

    public void markPaid() {
        this.paid = true;
    }

    public void logExpense(String item, NaturalNumber cost) {
        assert item != null : "Violation of: description is not null";
        assert cost != null : "Violation of: cost is not null";

        this.items.add(item, new NaturalNumber1L(cost));
    }

    public NaturalNumber totalExpenses() {
        NaturalNumber total = new NaturalNumber1L(0);

        for (Map.Pair<String, NaturalNumber> p : this.items) {
            total.add(p.value());
        }

        return total;
    }

    public boolean hasExpenses() {
        if (this.items.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

}

public static void main(String[] args) {
    Invoice invoice = new Invoice();

    invoice.logExpense("Item1", new NaturalNumber1L(100));
    invoice.logExpense("Item2", new NaturalNumber1L(200));

    System.out.println("Total Expenses: " + invoice.totalExpenses()); // Should print 300

    System.out.println("Is Paid: " + invoice.isPaid()); // Should print false

    invoice.markPaid();

    System.out.println("Is Paid after marking: " + invoice.isPaid()); // Should print true
}
