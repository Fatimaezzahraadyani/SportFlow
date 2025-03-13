package SportFlow.dao;

import SportFlow.dto.RegisterDto;

import java.sql.*;

public class UserDAO extends ConnectDb{
    private static final String GET_USER_BY_EMAIL = "select * from users where email= ?;";
    private static final String INSERT_INTO_USERS = "insert into users(nom, email, password, role) values(?,?,?,?);";

    public UserDAO () {}

    public void registerUser(RegisterDto register) {
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement stmt = connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
                ){
            stmt.setString(1, register.getNom());
            stmt.setString(2, register.getEmail());
            stmt.setString(3, register.getRole());
            stmt.setString(4, register.getPassword());
            stmt.setString(5, register.getConfirmPassword());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();


        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
