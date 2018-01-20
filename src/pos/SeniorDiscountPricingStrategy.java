package pos;

public class SeniorDiscountPricingStrategy implements ISalePricingStrategy{
    
    private float percentage;
    
    public SeniorDiscountPricingStrategy(){
        this.percentage = (float) 0.20;
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
