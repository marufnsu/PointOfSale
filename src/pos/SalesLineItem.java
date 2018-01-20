package pos;

//import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class SalesLineItem {
    
    private ProductSpecification ps;
    private int quantity;

    public SalesLineItem(int id, int quantity){
        SaleFactory factory = new SaleFactory();
        ps = factory.getProductSpecification(id);
        
        this.quantity = quantity;
    }
    
    public int getSubTotal(){
        return quantity * ps.getPrice();
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setPs(ProductSpecification ps) {
        this.ps = ps;
    }

    public ProductSpecification getPs() {
        return ps;
    }
}
