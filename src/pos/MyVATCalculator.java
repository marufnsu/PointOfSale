package pos;
public class MyVATCalculator implements IVATCalculator {
    
    @Override
    public int getVatAmount(int saleTotal) {
        return (int) Math.round(saleTotal * 0.05);
    }
}
