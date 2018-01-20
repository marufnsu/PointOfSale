package pos;

public class ProductSpecification extends PersistentObject {

    private String name;
    private String description;
    private int price;
    
    IManufacturer manufacturer;

    public IManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(IManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public String getManufacturerAddress(){
        return manufacturer.getAddress();
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}