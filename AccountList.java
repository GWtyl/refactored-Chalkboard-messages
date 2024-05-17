import java.util.*;
public class AccountList {
    
    private Accounts account;
    private Set<Accounts> accountList;
    private static int counter = 0;


    public AccountList(){
        this.accountList = new HashSet<>();
    }

    public void CreateAccount(String username, String password, String q1, String q2, String q3){
        this.account = new Accounts(username,  password, q1, q2, q3);
        if(this.accountList.add(account) == false){
            System.out.println("account already exists");
            return;
        } 
        this.accountList.add(account);//boolean function can check if account exists already
    }
    



    
}
