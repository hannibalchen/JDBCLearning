import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        InputStream is = loader.getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        info.load(is);
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String url = info.getProperty("url");
        String driverClass = info.getProperty("driverClass");
        Class.forName("driverClass");
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public static void closeConnection(Connection con, Statement ps){
            try {
                    if (ps!=null){
                        ps.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            try {
                if(con!=null){
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

