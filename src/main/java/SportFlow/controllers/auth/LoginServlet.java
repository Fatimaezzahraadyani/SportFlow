package SportFlow.controllers.auth;

import SportFlow.dao.ConnectDb;
import SportFlow.dao.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = null;

    public void init() {
        userDAO = new UserDAO();

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ConnectDb connectDb = new ConnectDb();
        connectDb.getConnection();

        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/login.jsp");
        rs.forward(req, res);
    }

}
