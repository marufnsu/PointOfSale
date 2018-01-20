package pos;

public class BDVATAdapter implements IVATCalculator{
    private BDVATCalculator b;
    
    public BDVATAdapter(){
        b = new BDVATCalculator();
    }
    
    @Override
    public int getVatAmount(int saleTotal) {
        int total = (int) b.calculateVatAmount(saleTotal);
        return total;
    }   
}
