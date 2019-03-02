package parameter.patent;


//修改持有人，需要于使用者中删除原持有人
public class Transaction {

    private String patentid;
    private String from_owner;
    private String to_owener;

    public String getPatentid() {
        return patentid;
    }

    public String getFrom_owner() {
        return from_owner;
    }

    public String getTo_owener() {
        return to_owener;
    }

    public Transaction(String id, String preowner, String toowner){
        this.patentid=id;
        this.from_owner=preowner;
        this.to_owener=toowner;
    }
}
