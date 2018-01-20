package pos;

public class CompositeBestForCustomerPricingStrategy extends CompositePricingStrategy {

    @Override
    public int getTotal(Sale s) {

        int lowestTotal = Integer.MAX_VALUE;
        for (ISalePricingStrategy strat : getPricingStrategies()) {
            lowestTotal = Math.min(strat.getTotal(s), lowestTotal);
        }

        return lowestTotal;
    }
}