package SportFlow.dao;

import SportFlow.dto.RegisterDto;
import SportFlow.model.User;

import java.sql.*;

public class UserDAO extends ConnectDb{
    private static final String GET_USER_BY_EMAIL = "select * from users where email= ?;";
    private static final String INSERT_INTO_USERS = "insert into users(nom, email,  role, password) values(?,?,?,?);";
    private static final String ADD_MEMBER = "INSERT INTO members (member_id) values (?);";


    public UserDAO () {}

    public void registerUser(RegisterDto registerDto) {
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement stmt = connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
                ){
            stmt.setString(1, registerDto.getNom());
            stmt.setString(2, registerDto.getEmail());
            stmt.setString(3, registerDto.getRole());
            stmt.setString(4, registerDto.getPassword());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Utilisateur enregistré avec succès !");
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("ID de l'utilisateur nouvellement inséré : " + id);
                }
            } else {
                System.out.println("Échec de l'enregistrement de l'utilisateur.");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addMember( int memberId ) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_MEMBER);
        ){
            stmt.setInt(1, memberId);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
