package pos;

import java.io.IOException;

public class PricingStrategyFactory {
    private static PricingStrategyFactory instance;
    private ISalePricingStrategy strategy;
    
    public static synchronized PricingStrategyFactory getInstance()
    {
        if(instance == null){
            instance = new PricingStrategyFactory();
        }
   
        return instance;
    }

    public ISalePricingStrategy getSalePricingStrategy() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException 
    {
        if(strategy == null)
        {
            Config config = new Config();
            String className = config.getProperties(SaleJFrame.getSelectedItem());
            strategy = (ISalePricingStrategy) Class.forName(className).newInstance();
            
            strategy.add(new AbsoluteDiscountOverThresholdPricingStrategy());
            strategy.add(new PercentDiscountPricingStrategy());
            if(SaleJFrame.isSenior())
                strategy.add(new SeniorDiscountPricingStrategy());
        }
        return strategy;
    }
}
