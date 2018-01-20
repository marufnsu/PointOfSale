package pos;
public abstract class AbstractPersistenceMapper implements IMapper {
    protected abstract Object getObjectFromStorage(int oid);
}
