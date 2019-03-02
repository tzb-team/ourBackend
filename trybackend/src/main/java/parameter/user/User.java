package parameter.user;

public class User {

    private String username;
    private String password;
    private String emailaddress;
    private String useraddress;

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public User(String username,String password,String emailaddress,String useraddress){
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
        this.useraddress = useraddress;
    }
}
