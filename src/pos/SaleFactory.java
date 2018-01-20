package pos;

import java.io.IOException;

public class SaleFactory {

    private static SaleFactory instance;
    private IVATCalculator vatCalculator;
   
    public ProductSpecification getProductSpecification(int id) {
        return (ProductSpecification) PersistenceFacade.getInsFacade().get(id, ProductSpecification.class);
    }

    public static synchronized SaleFactory getInstance() {
        if (instance == null) {
            instance = new SaleFactory();
            
        /*    
        ProductSpecification ps2 = new ProductSpecification();
        ps2.setId(2);
        ps2.setName("Biscuit");
        ps2.setPrice(30);
         PersistenceFacade.getInsFacade().put(ps2.getId(), ps2);

        ProductSpecification ps3 = new ProductSpecification();
        ps3.setId(3);
        ps3.setName("Ice Cream");
        ps3.setPrice(60);
        

        ProductSpecification ps4 = new ProductSpecification();
        ps4.setId(4);
        ps4.setName("Butter");
        ps4.setPrice(130);
        
        ProductSpecification ps5 = new ProductSpecification();
        ps5.setId(5);
        ps5.setName("Pepsi");
        ps5.setPrice(20);
        
        PersistenceFacade.getInsFacade().put(ps2.getId(), ps2);
        PersistenceFacade.getInsFacade().put(ps3.getId(), ps3);
        PersistenceFacade.getInsFacade().put(ps4.getId(), ps4);
        PersistenceFacade.getInsFacade().put(ps5.getId(), ps5);
            */
        }

        return instance;
    }

    public IVATCalculator getVatCalculator() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        if (vatCalculator == null) {
            Config config = new Config();
            String className = config.getProperties("vatcalculator.class.name");
            vatCalculator = (IVATCalculator) Class.forName(className).newInstance();
        }
        return vatCalculator;
    }
}
