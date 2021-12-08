import java.sql.Connection;
import java.sql.PreparedStatement;

public class CRUDTest {
    public void insertTest(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO customers(name,email,birth) VALUES(?,?,?);";
            ps = conn.prepareStatement(sql);

            ps.setObject(1,"zs");
            ps.setObject(2,"zs@163.com");

            ps.setObject(3,"zs");




        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
