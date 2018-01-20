package pos;

public class CompositeBestForStorePricingStrategy extends CompositePricingStrategy {

    @Override
    public int getTotal(Sale s) {

        int highestTotal = Integer.MIN_VALUE;
        for (ISalePricingStrategy strat : getPricingStrategies()) {
            highestTotal = Math.max(strat.getTotal(s), highestTotal);
        }

        return highestTotal;
    }
}
