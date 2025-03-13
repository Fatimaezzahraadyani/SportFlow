package SportFlow.dto;


import jakarta.validation.constraints.*;

@PasswordMatch
public class RegisterDto {
    public RegisterDto(){

    }

    @NotBlank(message = "nom is required")
    private String nom;

    @NotBlank(message = "email is reuqired")
    @Email
    private String email;

    @NotBlank(message = "please select a role")
    private String role;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "password confimation is required")
    private String confirmPassword;


    public RegisterDto (String nom, String email, String role, String password) {
        this.nom =nom;
        this.email = email;
        this.role = role;
        this.password = password;

    }




    public String getNom() {
        return nom;
    }



    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setNom( String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}