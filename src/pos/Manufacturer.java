package pos;
public class Manufacturer extends PersistentObject implements IManufacturer{
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String getAddress() {       
        return address;
    }
}