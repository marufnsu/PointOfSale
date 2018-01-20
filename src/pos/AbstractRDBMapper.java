package pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRDBMapper extends AbstractPersistenceMapper{
    String tableName;
    public AbstractRDBMapper(String a)
    {
        tableName = a;
    }
    
    @Override
    protected final Object getObjectFromStorage(int oid){
        return getObjectFromRecord(oid,getDBRecord(oid)); 
    }
    
    protected abstract Object getObjectFromRecord(int oid, ResultSet dbRecord);
    
    public ResultSet getDBRecord(int oid)
    {
        Connection conn = DataBaseConnection.connectTODB();
        try {
            String query = "select * from "+tableName+" where id=?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, oid);
            return statement.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error coming from Abstract RDB MAPPer");
            return null;
        }        
    }
}
