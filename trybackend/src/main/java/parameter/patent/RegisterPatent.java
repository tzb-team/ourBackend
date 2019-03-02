package parameter.patent;

public class RegisterPatent {

    private String patent_id;
    private String patent_owner;
    private String poolid;

    public String getPatent_id() {
        return patent_id;
    }

    public String getPatent_owner() {
        return patent_owner;
    }

    public String getPoolid() {
        return poolid;
    }

    //留一个初始化接口，以备文件解析失败时，手动录入
    public RegisterPatent(String id, String owner, String poolid){

        this.patent_id=id;
        this.patent_owner=owner;
        this.poolid=poolid;
    }
}
