
//This is created by Joshua
//import java.io.*;
//this class will be used to store all the accounts
import java.util.HashMap;
import java.util.Map;
public class Accounts {
   // BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
    
    private String[] accounts; //stores by username, password basis
    private String[]sQuestions;

    //create a constructor that creates the account
    public Accounts(String username, String password, String q1, String q2, String q3){
        this.accounts = new String[2];
        this.accounts[0] = username;
        this.accounts[1] = password;
        this.sQuestions = new String[3];
        this.sQuestions[0] = q1;
        this.sQuestions[1] = q2;
        this.sQuestions[2] = q3;

    }
    
    //replaces the old password with the new password for the account
    public boolean changePassword(String username,String password){
        if(this.accounts[0].equals(username)){
            this.accounts[1] = password;
            return true;
        }
        return false;
    }

    public String getUsername(){
        return this.accounts[0];
    }

    private String getPassword(){
        return this.accounts[1];
    }

}
