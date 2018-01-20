package pos;

public class ManufacturerProxy extends PersistentObject implements IManufacturer {

    IManufacturer realSubject;
    //private int manu_id;

    public ManufacturerProxy(int manu_id){
       // this.manu_id = manu_id;
        setId(manu_id);
    }
    
    @Override
    public String getAddress() {
        return getRealSubject().getAddress();
    }

    public IManufacturer getRealSubject() {
        if(realSubject == null){
          //realSubject = (IManufacturer) PersistenceFacade.getInsFacade().get(manu_id,Manufacturer.class);
          realSubject = (IManufacturer) PersistenceFacade.getInsFacade().get(getId(),Manufacturer.class);
        }
        return realSubject;
    }
}
