import components.naturalnumber.NaturalNumber;

/**
 * Enhanced interface for {@code Invoice}, extending {@code InvoiceKernel}.
 * Provides additional convenience methods layered on top of the kernel.
 *
 * @author Keshav Fernando
 */

public interface Invoice extends InvoiceKernel {
    /**
     * Calculates the total of all expenses in this invoice.
     *
     * @return the total cost of all items
     * @ensures totalExpenses = [sum of all item costs in this invoice]
     */
    NaturalNumber totalExpenses();

    /**
     * Reports whether this invoice has any logged expenses.
     *
     * @return true if there are one or more expense items, false otherwise
     * @ensures hasExpenses = [this.items.size() > 0]
     */
    boolean hasExpenses();

}
