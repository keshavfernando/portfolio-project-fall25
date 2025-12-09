import components.map.Map;
import components.naturalnumber.NaturalNumber;
import components.standard.Standard;

/**
 * Kernel component for {@code Invoice}.
 *
 * @author Keshav Fernando
 */

public interface InvoiceKernel extends Standard<Invoice> {
    /**
     * Adds an expense to this invoice.
     *
     * @param item
     *            the name of the expense
     * @param cost
     *            the cost associated with the expense
     * @requires item is not in domain(this)
     * @ensures [item is added to this with given cost]
     */
    void addItem(String item, NaturalNumber cost);

    /**
     * Marks this invoice as paid.
     *
     * @updates this
     * @ensures isPaid()
     */
    void markPaid();

    /**
     * Reports whether this invoice is paid.
     *
     * @return true if this invoice is paid, false otherwise
     * @ensures isPaid = [whether this invoice is marked as paid]
     */
    boolean isPaid();

    /**
     * Returns the map of items and their corresponding costs.
     *
     * @return the map representing this invoice
     * @ensures totalExpenses() = sum of all item costs
     */
    Map<String, NaturalNumber> items();
}
