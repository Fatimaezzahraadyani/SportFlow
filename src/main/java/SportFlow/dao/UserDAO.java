package SportFlow.dao;

import SportFlow.dto.RegisterDto;
import SportFlow.model.User;

import java.sql.*;

public class UserDAO extends ConnectDb {
    private static final String GET_USER_BY_EMAIL = "select * from users where email= ?;";
    private static final String INSERT_INTO_USERS = "insert into users(nom, email,  role, password) values(?,?,?,?);";
    private static final String ADD_MEMBER = "INSERT INTO membres (member_id) values (?);";
    private static final String ADD_TRAINER = "INSERT INTO trainers (trainer_id) values (?);";
    private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";


    public UserDAO() {
    }

    public void registerUser(RegisterDto registerDto) {
        try
                (
                        Connection connection = getConnection();
                        PreparedStatement stmt = connection.prepareStatement(INSERT_INTO_USERS, Statement.RETURN_GENERATED_KEYS);
                ) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUserByEmail(String email) {
        User user = null;


        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_USER_BY_EMAIL)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void addMember(int memberId) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_MEMBER);
        ) {
            stmt.setInt(1, memberId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTrainer(int trainerId) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(ADD_TRAINER);
        ) {
            stmt.setInt(1, trainerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(int userId) {
        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement(DELETE_USER_BY_ID);
        ) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}