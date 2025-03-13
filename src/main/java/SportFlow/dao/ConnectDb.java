package SportFlow.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {


        private final String dbURI = "jdbc:mysql://localhost:3306/sportflow?useSSL=false";
        private final String dbUsername = "root";
        private final String dbPassword = "admin";

        public ConnectDb(){}

        public Connection getConnection () {
            Connection con = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(dbURI, dbUsername, dbPassword);
                System.out.println("database connected");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return con;
        }

}


