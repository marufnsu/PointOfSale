package pos;

public class PercentDiscountPricingStrategy implements ISalePricingStrategy{
    
    private float percentage;
    
    public PercentDiscountPricingStrategy(){
        this.percentage = (float) 0.10;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public int getTotal(Sale s) {
        return (int)  Math.round(s.getPreDiscountTotal() - (s.getPreDiscountTotal() * percentage));
    }

    @Override
    public void add(ISalePricingStrategy strategy) {
    }
}
