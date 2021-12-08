import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void testConnection1() throws SQLException {
        Driver driver= new com.mysql.cj.jdbc.Driver();

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");

        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = driver.connect(url,properties);
        System.out.println(connection);
    }

    @Test
    public void testConnection5() throws SQLException, IOException, ClassNotFoundException {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties info = new Properties();
        info.load(is);

        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String url = info.getProperty("url");
        String driverClass = info.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);

    }
}


