package parameter.patent;

public class UserAddition {

    private String patent_id;
    private String user;

    public String getPatent_id() {
        return patent_id;
    }

    public String getUser() {
        return user;
    }

    public UserAddition(String id, String user){
        this.patent_id=id;
        this.user=user;
    }
}
