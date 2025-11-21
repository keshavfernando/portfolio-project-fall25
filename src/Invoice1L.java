import components.map.Map;
import components.map.Map1L;
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * Invoice kernel implementation of Map using Map1L.
 *
 * Representation: items: Map<String, NaturalNumber> paid: boolean
 *
 * Convention: - items != null - all keys (Strings) are non-null - all values
 * (NaturalNumber) are non-null - keys are unique - paid is either true or false
 *
 * Correspondence: - this.items represents the set of item and costs in the
 * invoice - this.paid corresponds to the payment status
 */
public class Invoice1L extends InvoiceSecondary {

    /**
     * Representation variables.
     */
    private Map<String, NaturalNumber> items;
    private boolean paid;

    /**
     * No-argument constructor.
     */
    public Invoice1L() {
        this.createNewRep();
    }

    @Override
    public final Map<String, NaturalNumber> items() {
        return this.items.newInstance().transferFrom(this.items);
    }

    @Override
    public final boolean isPaid() {
        return this.paid;
    }

    @Override
    public final void markPaid() {
        this.paid = true;
    }

    @Override
    public final void logExpense(String item, NaturalNumber cost) {
        assert item != null : "Violation of: item is not null";
        assert cost != null : "Violation of: cost is not null";

        this.items.add(item, new NaturalNumber1L(cost));
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final Invoice newInstance() {
        return new Invoice1L();
    }

    @Override
    protected final void createNewRep() {
        this.items = new Map1L<>();
        this.paid = false;
    }

    @Override
    public final void transferFrom(Invoice source) {
        Invoice1L src = (Invoice1L) source;

        this.items = src.items;
        this.paid = src.paid;

        src.createNewRep();
    }
}