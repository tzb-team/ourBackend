package parameter.patent;


//      验证挂单发起者是否是专利持有人是web3的职责，这里只负责修改valid
public class PendOrder {

    private String patent_id;
    private int value;

    public String getPatent_id() {
        return patent_id;
    }
    public int getValue(){
        return this.value;
    }

    public PendOrder(String id, int value){
        patent_id=id;
        this.value=value;
    }
}
