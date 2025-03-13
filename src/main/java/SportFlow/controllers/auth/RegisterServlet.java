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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/auth/register")
public class RegisterServlet extends HttpServlet {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    private UserDAO userDAO = null;
    public void init(){
        userDAO = new UserDAO();

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException , IOException
    {
        ConnectDb connectDb = new ConnectDb();
        connectDb.getConnection();

        RequestDispatcher rs = req.getRequestDispatcher("/views/auth/register.jsp");
        rs.forward(req, res);
    }
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
            throws ServletException , IOException
    {
        User user = null;

        String nom = req.getParameter("nom");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        RegisterDto registerDto = new RegisterDto(nom,email,role,password,confirmPassword);

        Set<ConstraintViolation<RegisterDto>> violations = validator.validate(registerDto);
        HttpSession session = req.getSession();
        Map<String, String> errors = new HashMap<>();

        if(!violations.isEmpty()){
            for (ConstraintViolation<RegisterDto> violation: violations){
                errors.put(violation.getPropertyPath().toString(),violation.getMessage());
            }
            session.setAttribute("errors",errors);
            session.setAttribute("old",registerDto);
            res.sendRedirect(req.getContextPath()+"auth/register");


        }






    }


}
