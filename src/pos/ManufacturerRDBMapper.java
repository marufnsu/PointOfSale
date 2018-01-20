package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManufacturerRDBMapper extends AbstractRDBMapper{
    
    private Connection conn = null;
    private PreparedStatement statement ;
    
    public ManufacturerRDBMapper(String tableName) {
        super(tableName);
    }

    @Override
    protected Object getObjectFromRecord(int oid, ResultSet dbRecord) {
        Manufacturer manu = new Manufacturer();
        try {
            while(dbRecord.next()){
                manu.setAddress(dbRecord.getString("address"));
                return manu;
            }
        } catch (SQLException ex) {
            System.out.println("Error from Prodcut RDB Mapper.");
            System.out.println(ex.toString());
            return null;
        }
        return null;
    }

    @Override
    public void put(int oid, Object o) {
        try {
            Manufacturer saveManu = (Manufacturer) o;
            
            String sql = "insert into manufacturer values("+saveManu.getAddress()+",'"+saveManu.getAddress()+")";
            conn = DataBaseConnection.connectTODB();
            statement = conn.prepareStatement(sql);        
            statement.execute(); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    @Override
    public Object get(int oid, Class PersistenceClass) {
        return getObjectFromRecord(oid, super.getDBRecord(oid));
    }
}