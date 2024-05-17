
//This is created by Joshua
import java.io.*;
//this class will be used to store all the accounts
import java.util.*;

import javax.imageio.ImageIO;
public class Accounts {
   // BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
    
    private String[] accounts; //stores username and password; index 0 is username, 1 is password
    private String[]sQuestions; //stores the security questions
    private List<String>friends; //stores all the friends
    private List<String>dm; //stores all the dms with friends
    private List<ImageIO>images; //stores all posts
    private Set<List<String>>dmList; //stores all different conversations with different friends


    //create a constructor that creates the account
    //initializes everything that an account  needs
    public Accounts(String username, String password, String q1, String q2, String q3){
        this.friends = new ArrayList<>();
        this.images = new ArrayList<>();
        this.dmList = new HashSet<>();
        this.accounts = new String[2];
        this.accounts[0] = username;
        this.accounts[1] = password;
        this.sQuestions = new String[3];
        this.sQuestions[0] = q1;
        this.sQuestions[1] = q2;
        this.sQuestions[2] = q3;

    }

    //returns the username
    public String getUsername(){
        return this.accounts[0];
    }

    //returns the password
    private String getPassword(){
        return this.accounts[1];
    }

    //returns the first security question
    private String getQ1(){
        return this.sQuestions[0];
    }

    //returns the second security question
    private String getQ2(){
        return this.sQuestions[1];
    }

    //returns the third security question
    private String getQ3(){
        return this.sQuestions[2];
    }

    private List<String> getFriendList(){
        return this.friends;
    }

    //checks if the security questions entered are the same(for resetting password)
    public boolean checkSecQues(String q1, String q2, String q3){
        return sQuestions[0] == q1 && sQuestions[1] == q2 && sQuestions[2] == q3;
    }

    //replaces the old password with the new password for the account
    //returns true/false if the password have been replaced
    public boolean changePassword(String username,String password){
        if(this.accounts[0].equals(username)){
            this.accounts[1] = password;
            return true;
        }
        return false;
    }

    //change security questions
    public boolean changeSecQues(String username, String q1, String q2, String q3){
        if(this.accounts[0].equals(username)){
            this.sQuestions[0] = q1;
            this.sQuestions[1] = q2;
            this.sQuestions[2] = q3;
            return true;
        }
       return false;
    }

    //add friends to the friend list
    public void addFriend(String friendName){
        this.friends.add(friendName);
    }

    //checks if the friend list have the friend name
    public boolean containsFriend(String friendName){
        return this.friends.contains(friendName);
    }

    //start messaging if the friend exists
    public void message(String friendName,String message){
        if(containsFriend(friendName)){
            this.dm = new ArrayList<>();
            this.dm.add(friendName);
            this.dm.add(message);
            this.dmList.add(dm);
        }

        else if(this.dm.contains(friendName)){
            this.dm.add(message);
        }
    }





}
