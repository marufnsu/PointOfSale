package pos;

import java.util.ArrayList;

public class CompositePricingStrategy implements ISalePricingStrategy {

    private ArrayList<ISalePricingStrategy> pricingStrategies = null;

    public ArrayList<ISalePricingStrategy> getPricingStrategies() {
        return pricingStrategies;
    }

    @Override
    public void add(ISalePricingStrategy isps) {
        if (pricingStrategies == null) {
            pricingStrategies = new ArrayList<>();
        }

        pricingStrategies.add(isps);
    }

    @Override
    public int getTotal(Sale s) {
        return 0;
    }
}
