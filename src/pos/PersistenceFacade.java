package pos;

import java.util.HashMap;

public class PersistenceFacade {

    public static PersistenceFacade pf;
    private static HashMap mappers;

    public static synchronized PersistenceFacade getInsFacade() {
        if (pf == null) {
            pf = new PersistenceFacade();
            mappers = new HashMap<Class, IMapper>();
            mappers.put(ProductSpecification.class, new ProductSpecificationRDBMapper("productspecification"));
            mappers.put(Manufacturer.class, new ManufacturerRDBMapper("manufacturer"));
        }
        return pf;
    }

    public void put(int oid, Object persistentObject) {
        IMapper imapper = (IMapper) mappers.get(persistentObject.getClass());
        imapper.put(oid, persistentObject);
    }
    
    public Object get(int oid, Class persistenceClass){
        IMapper imapper = (IMapper) mappers.get(persistenceClass);
        return imapper.get(oid, persistenceClass);
    }
}