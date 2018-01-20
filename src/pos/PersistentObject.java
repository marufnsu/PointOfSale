package pos;

public class PersistentObject {
    private int oid;

    public void setId(int oid) {
        this.oid = oid;
    }

    public int getId() {
        return oid;
    }
}
