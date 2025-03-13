package SportFlow.controllers.auth;

import SportFlow.dao.ConnectDb;
import SportFlow.dao.UserDAO;
import SportFlow.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/auth/login")
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

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        //User user = null;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        //verification des champs
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            req.setAttribute("loginError", "Veuillez entrer votre email et mot de passe.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
            dispatcher.forward(req, res);
            return;
        }
        User user = userDAO.getUserByEmail(email);

        if(user!=null && user.getPassword().equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            res.sendRedirect(req.getContextPath()+"/dashboard"); //redirection vers dashbord
        }else {
            req.setAttribute("loginError","Email or password invalid");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/auth/login.jsp");
            dispatcher.forward(req,res);
        }


    }
}