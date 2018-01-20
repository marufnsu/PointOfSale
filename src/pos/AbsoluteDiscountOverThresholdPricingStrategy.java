package pos;

public class AbsoluteDiscountOverThresholdPricingStrategy implements ISalePricingStrategy {

    private int discount;
    private int threshold;

    public AbsoluteDiscountOverThresholdPricingStrategy() {
        this.discount = 100;
        this.threshold = 1000;
    }

    @Override
    public int getTotal(Sale s) {
        if (s.getPreDiscountTotal() < threshold) {
            return s.getPreDiscountTotal();
        } else {
            return s.getPreDiscountTotal() - discount;
        }
    }

    @Override
    public void add(ISalePricingStrategy strategy) {
    }
}