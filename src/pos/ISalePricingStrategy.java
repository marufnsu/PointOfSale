package pos;

public interface ISalePricingStrategy {
    public int getTotal(Sale s);
    public void add(ISalePricingStrategy strategy);
}