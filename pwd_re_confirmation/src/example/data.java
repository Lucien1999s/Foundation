package example;

import java.io.Serializable;

public class data implements Serializable {
    protected String pwd;
    public data(String pwd){
        this.pwd = pwd;
    }
    public void check(String pwd1,String pwd2)throws dataError{
        if(pwd1.equals(pwd) && pwd2.equals(pwd)){
            System.out.print("密碼正確");
            System.exit(0);
        }
        else {
            throw new dataError("密碼輸入錯誤,請重輸入!");
        }
    }
}
