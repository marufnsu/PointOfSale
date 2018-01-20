package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProductSpecificationRDBMapper extends AbstractRDBMapper{

    private Connection conn = null;
    private PreparedStatement statement ;

    public ProductSpecificationRDBMapper(String tableName) {
        super(tableName);
    }


    @Override
    public void put(int oid, Object object) {
        try {
            ProductSpecification savePS = (ProductSpecification) object;
           
            int id = savePS.getId();
            String name = savePS.getName();
            String description = savePS.getDescription();
            int price = savePS.getPrice();
            
            String sql = "insert into productspecification values("+id+",'"+name+"','"+description+"',"+price+")";
            conn = DataBaseConnection.connectTODB();
            statement = conn.prepareStatement(sql);        
            statement.execute(); 
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    @Override
    public Object get(int oid,Class PersistenceClass) {
        return getObjectFromRecord(oid, super.getDBRecord(oid));
    }

    @Override
    protected Object getObjectFromRecord(int oid, ResultSet dbRecord) {       
        ProductSpecification ps = new ProductSpecification();
        try {
            while(dbRecord.next()){
                ps.setId(dbRecord.getInt("id"));
                ps.setName(dbRecord.getString("name"));
                ps.setDescription(dbRecord.getString("description"));
                ps.setPrice(dbRecord.getInt("price"));
                ps.setManufacturer(new ManufacturerProxy(dbRecord.getInt("manu_id")));
            
                return ps;
            }
        } catch (SQLException ex) {
            System.out.println("Error from Prodcut RDB Mapper.");
            System.out.println(ex.toString());
            return null;
        }
        return null;
    }
}