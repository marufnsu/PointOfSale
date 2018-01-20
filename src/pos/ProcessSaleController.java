package pos;

import java.io.IOException;
import javax.swing.JOptionPane;

public class ProcessSaleController {
    private Sale sale;
    BeepSoundNotifier beeper;
    
    public void makeNewSale(){
        sale = new Sale();
        beeper = new BeepSoundNotifier();
    }
    
    public void addItem(int id, int quantity){
        try {
            sale.addSaleLineItem(id, quantity);
        } 
        catch(IOException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    public void addListenerToSale(IPropertyListener ipl){
        sale.addPropertyListener(ipl);
        sale.addPropertyListener(beeper);
    }
    public Sale getSale(){
        return this.sale;
    }
}
