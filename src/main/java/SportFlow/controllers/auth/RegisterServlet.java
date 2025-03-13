package SportFlow.controllers.auth;

import SportFlow.dao.ConnectDb;
import SportFlow.dao.UserDAO;
import SportFlow.dto.RegisterDto;
import SportFlow.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;


@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    private UserDAO userDAO = null;

    public void init() {
        userDAO = new UserDAO();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ConnectDb connectDb = new ConnectDb();
        connectDb.getConnection();

        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/register.jsp");
        rs.forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String password = req.getParameter("password");

        if (nom == null || email == null || role == null || password == null ||
                nom.isEmpty() || email.isEmpty() || role.isEmpty() || password.isEmpty()) {
            session.setAttribute("registerError", "Tous les champs sont obligatoires !");
            res.sendRedirect(req.getContextPath() + "/auth/register");
            return;
        }
            RegisterDto registerDto = new RegisterDto(nom, email, role, password);
            try {
                userDAO.registerUser(registerDto);
                System.out.println("user enregistrer");
                session.setAttribute("registerSuccess","Registration valide ! please login");
                res.sendRedirect(req.getContextPath()+"/auth/login");

            }catch (Exception e){
                System.out.println("errors lors de l'enregistrement de l'utilisateur : \" + e.getMessage()");
                session.setAttribute("registerError", "NOT VALID");
                res.sendRedirect(req.getContextPath() + "/auth/register");
            }
            userDAO.registerUser(registerDto);
            session.setAttribute("registerSuccess", "Please login");
        }




    }

