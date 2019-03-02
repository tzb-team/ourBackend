package parameter.user;

public class Log {

    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    public Log(String email,String password){
        this.email = email;
        this.password = password;
    }
}
