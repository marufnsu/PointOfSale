package pos;

import java.io.IOException;
import java.util.ArrayList;

public class Sale {

    private IVATCalculator ivac;
    private int total;
    private ArrayList<SalesLineItem> sli;
    private ISalePricingStrategy strategy;
    private ArrayList<IPropertyListener> propertyListeners;

    public Sale() {
        sli = new ArrayList<SalesLineItem>();
        total = 0;
        propertyListeners = new ArrayList<>();
    }

    public void addSaleLineItem(int id, int quantity) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        SalesLineItem item = new SalesLineItem(id, quantity);
        sli.add(item);
        
        //publisher & subscriber
        setTotal(getTotal());
    }

    public int getPreDiscountTotal() {
        return total;
    }

    public int getTotal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        total = 0;
        for (int i = 0; i < sli.size(); i++) {
            total += sli.get(i).getSubTotal();
        }

        strategy = PricingStrategyFactory.getInstance().getSalePricingStrategy();
        return strategy.getTotal(this);
    }

    public int getDiscountAmount() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        strategy = PricingStrategyFactory.getInstance().getSalePricingStrategy();
        return (-1) * (this.getTotal() - this.getPreDiscountTotal());
    }

    public int getVATAmount() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ivac = SaleFactory.getInstance().getVatCalculator();
        return ivac.getVatAmount(this.getTotal());
    }

    public int getGrandTotal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        return this.getTotal() + this.getVATAmount();
    }

    public ArrayList<SalesLineItem> getSli() {
        return sli;
    }

    //=========Publisher & Subscriber elements=========================
    public void addPropertyListener(IPropertyListener lis) {
        propertyListeners.add(lis);
        //System.out.println("added");
    }

    public void publishPropertyEvent(String name, String value) {
        for (IPropertyListener pl : propertyListeners) {
            pl.onPropertyEvent(name, value);
        }
    }
    
    public void setTotal(int newTotal){
        total = newTotal;
        publishPropertyEvent("sale.total", String.valueOf(newTotal));
    }
}