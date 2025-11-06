import components.map.Map;
import components.map.Map.Pair;
import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

public abstract class InvoiceSecondary implements Invoice {

    @Override
    public final NaturalNumber totalExpenses() {
        NaturalNumber total = new NaturalNumber1L(0);

        Map<String, NaturalNumber> itemsCopy = this.items();

        for (Pair<String, NaturalNumber> p : itemsCopy) {
            NaturalNumber cost = p.value();
            total.add(cost);
        }

        return total;
    }

    @Override
    public final boolean hasExpenses() {
        Map<String, NaturalNumber> itemsCopy = this.items();
        return itemsCopy.size() > 0;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice [Status: ");
        sb.append(this.isPaid() ? "PAID" : "UNPAID");
        sb.append(", Items: {");

        Map<String, NaturalNumber> itemMap = this.items();
        boolean first = true;

        for (Pair<String, NaturalNumber> p : itemMap) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(p.key()).append(": ").append(p.value());
            first = false;
        }

        sb.append("}]");
        return sb.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Invoice)) {
            return false;
        }

        Invoice other = (Invoice) obj;

        return this.isPaid() == other.isPaid()
                && this.items().equals(other.items());
    }
}
