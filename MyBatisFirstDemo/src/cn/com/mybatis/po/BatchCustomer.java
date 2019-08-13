package cn.com.mybatis.po;

/**
 * Created By xiaoweiping 2019/8/13 16:52
 **/
public class BatchCustomer  extends Batch{
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    private String username;
    private String acno;
}
