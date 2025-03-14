package SportFlow.model;
import java.util.Date;


public class Member extends User{

    private int member_id;
    private String sport;
    private Date date_naissence;

    public Member(int id, String nom, String email, String role, String password, int member_id, String sport, Date date_naissence) {
        super(id, nom, email, role, password);
        this.member_id = member_id;
        this.sport = sport;
        this.date_naissence = date_naissence;
    }

    public Member(String nom, String email, String role, String password, int member_id, String sport, Date date_naissence) {
        super(nom, email, role, password);
        this.member_id = member_id;
        this.sport = sport;
        this.date_naissence = date_naissence;
    }

    public Member(int id, String nom, String email, String role, int member_id, String sport, Date date_naissence) {
        super(id, nom, email, role);
        this.member_id = member_id;
        this.sport = sport;
        this.date_naissence = date_naissence;
    }

    public Member(int id, String nom, String email, int member_id, String sport, Date date_naissence) {
        super(id, nom, email);
        this.member_id = member_id;
        this.sport = sport;
        this.date_naissence = date_naissence;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Date getDate_naissence() {
        return date_naissence;
    }

    public void setDate_naissence(Date date_naissence) {
        this.date_naissence = date_naissence;
    }
}
