package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class user {
    @Column (name = "username",length = 20)
    private String username;

    @Column (name = "password",length = 20)
    private String password;

    @Id
    @Column (name = "emailaddress",length = 20)
    private String emailaddress;

    @Column (name = "walletaddress",length = 20)
    private String walletaddress;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public String getWalletaddress() {
        return walletaddress;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public void setWalletaddress(String walletaddress) {
        this.walletaddress = walletaddress;
    }


    public user(){

    }

    public user(String username,String password,String emailaddress,String walletaddress){
        this.username=username;
        this.password=password;
        this.emailaddress=emailaddress;
        this.walletaddress=walletaddress;
    }
}
