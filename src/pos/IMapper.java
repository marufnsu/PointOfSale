package pos;

public interface IMapper {
    
    public void put(int oid ,Object o);
    public Object get(int oid,Class PersistenceClass);
}
