package SportFlow.model;

public class User {
    private int id;
    private String nom;
    private String email;
    private String role;

    private String password;

    //constructer
    public User(int id, String nom, String email, String role, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    //constructer sans id
    public User(String nom, String email, String role, String password) {
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.password = password;
    }
    //constructer sans password
    public User(int id, String nom, String email, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
    }

    public User(int id,String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;

    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
