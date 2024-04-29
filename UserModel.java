import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

/**
 * UserModel class automatically creates and loads all accounts into an array
 * and indexes the account specific to the current user to make changes or access information
 * 
 * The UserController takes inputs from the view classes and sends it to this UserModel
 * to validate information and make these changes
 */

class UserModel {
    private ArrayList<ArrayList<String>> accountArray;
    private int currentAccountIndex;
    // array of account looks like "username, password, security one, security two, security three, friends"
    //                                  0          1          2           3               4               5+
    
    // constructor
    public UserModel(){
        this.accountArray = new ArrayList<ArrayList<String>>();
        this.currentAccountIndex = -1;   // no accounts indexed until the user logs in or creates account
    }
    // automatically loads all accounts into ArrayList<ArrayList<String>> with BufferedReader
    public void loadAccounts(){
        String currentDirectory = System.getProperty("user.dir");
        File accountsCSV = new File(currentDirectory + "/accounts.csv");

        if (accountsCSV.exists()){

            BufferedReader bufferedReader = null;
            try {		
                bufferedReader = new BufferedReader(new FileReader("accounts.csv"));		
                // skip header
                bufferedReader.readLine();
                // read an account
                String infoLine = bufferedReader.readLine();

                while (infoLine != null) {
                    // create arrayList of that account
                    ArrayList<String> anAccount = new ArrayList<String>();
                    
                    String[] infoList = infoLine.split(", ");
                    for (String info: infoList){
                        anAccount.add(info);
                    }
                    // put that account arraylist into the arrayList of all accounts (2d array)
                    accountArray.add(anAccount);
                    infoLine = bufferedReader.readLine();
                }			
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                try {
                    if (bufferedReader != null){
                        bufferedReader.close();
                    }
                } 
                catch (IOException e){
                    System.out.println("Error in closing the BufferedReader");
                }
            }
        }
    }
    /**
     * Take user inputs and check if they meet account creation requirements
     * If one credential does not meet the requirements, the failure will be returned to the UserController
     * and the user will be notified.
     * When all the credentials meet the requirements, the account will be added to the csv of all accounts.
     * The current user's account will also be indexed so the program can make changes to it as the user wishes.
     *
     * @param  all String parameters needed to create an account
     * @return String of a failed credential or success to let the user know
     */
    public String createAccount(String username, String password, String secOne, String secTwo, String secThree){
        String success = "createdAcc";
        if (compareAllUsernames(username)==true){
            success = "failUsername";
        }
        else if (checkPasswordReq(password)==false){
            success = "failPassword";
        }
        else {
            ArrayList<String> newAcc = new ArrayList<String>();
            newAcc.add(username);
            newAcc.add(password);
            newAcc.add(secOne);
            newAcc.add(secTwo);
            newAcc.add(secThree);
            accountArray.add(newAcc);
            printChangesAccountsCSV();
            getCurrentAccIndex(username);
        }
        return success;
    }
    /**
     * UserController takes username and password from WelcomeView and gives it to UserModel
     * to validate.
     * If the username exists and the password matches the username, user will log in
     *
     * @param  String username and password
     * @return boolean true or false to indicate successful log in or not
     */
    public boolean logIn(String username, String password){
        boolean loggingIn = false;
        boolean accExist = compareAllUsernames(username);
        if (accExist){
            getCurrentAccIndex(username);
            if (comparePassword(password)){
                loggingIn = true;
            }
        }
        return loggingIn;
    }
    /**
     * Method checks if the username exists and if the three security answers match the username
     * If username does not exist, or a security question is wrong, return fail
     * If all fields are correct, return user's password so they can log in
     *
     * @param  String username and three security questions input from user
     * @return String of fail if user entered a field wrong, or the user's password if they get everything right
     */
    public String forgotPassword(String username, String secOne, String secTwo, String secThree){
        String success = "fail";
        boolean q1 = false;
        boolean q2 = false;
        boolean q3 = false;
        boolean accExist = compareAllUsernames(username);
        if (accExist){
            getCurrentAccIndex(username);
            if (compareSecurityOne(secOne)){
                q1 = true;
            }
            if (compareSecurityTwo(secTwo)){
                q2 = true;
            }
            if (compareSecurityThree(secThree)){
                q3 = true;
            }
        }
        if (q1 && q2 && q3){
            success = accountArray.get(currentAccountIndex).get(1);
        }
        return success;
    }
    /**
     * Takes the username of a potential friend and checks whether they exist or is already a friend
     * If so, the friends will automatically be added and the system will notify the user
     * If the user does not exist, the system will notify the user
     *
     * @param  String friend's username
     * @return boolean of whether or not friend was added
     */
    public boolean searchUser(String username){
        if (alreadyFriends(username)){
            return true;
        }
        else if (compareAllUsernames(username)){
            addFriend(username);
            printChangesAccountsCSV();
            return true;
        }
        return false;
    }
    /**
     * Check if current password is correct
     * If it is, then it will check if the new password meets requirements.
     * If it also meets requirements, the password will be updated in the array and csv file
     *
     * @param  String current and new password
     * @return If the current or new password is not correct, the appropiate String will be returned to notify the user
     */
    public String changePassword(String currentPassword, String newPassword){
        String success = "currentPassword";
        if (comparePassword(currentPassword)){
            success = "newPassword";
            if (checkPasswordReq(newPassword)){
                updatePassword(newPassword);
                printChangesAccountsCSV();
                success = "done";
            }
        }
        return success;
    }
    /**
     * takes user's new security answers and updates them in csv and account array
     */
    public void changeSecurity(String secOne, String secTwo, String secThree){
        updateSecurityOne(secOne);
        updateSecurityTwo(secTwo);
        updateSecurityThree(secThree);
        printChangesAccountsCSV();
    }
    // getters
    public String getUsername(){
        return accountArray.get(currentAccountIndex).get(0);
    }
    public String getSecurityOne(){
        return accountArray.get(currentAccountIndex).get(2);
    }
    public String getSecurityTwo(){
        return accountArray.get(currentAccountIndex).get(3);
    }
    public String getSecurityThree(){
        return accountArray.get(currentAccountIndex).get(4);
    }

    
    
    //private helper methods

    /**
     * Takes username and searches 2D array of all accounts for the matching account
     * Current user index is set to the matching account to access user's information later
     */
    private void getCurrentAccIndex(String username){
        for (int i = 0; i < accountArray.size(); i++){
            if (accountArray.get(i).get(0).equals(username)){
                currentAccountIndex = i;
            }
        }
    }
    // setters
    private void updatePassword(String password){
        accountArray.get(currentAccountIndex).set(1, password);
    }
    private void updateSecurityOne(String answer){
        accountArray.get(currentAccountIndex).set(2, answer);
    }
    private void updateSecurityTwo(String answer){
        accountArray.get(currentAccountIndex).set(3, answer);
    }
    private void updateSecurityThree(String answer){
        accountArray.get(currentAccountIndex).set(4, answer);
    }
    // validation of credentials that return boolean
    private boolean compareAllUsernames(String username){
        for (int i = 0; i < accountArray.size(); i++){
            if (accountArray.get(i).get(0).equals(username)){
                return true;
            }
        }
        return false;
    }
    private boolean comparePassword(String password){
        if (accountArray.get(currentAccountIndex).get(1).equals(password)){
            return true;
        }
        return false;
    }
    private boolean compareSecurityOne(String answer){
        if (accountArray.get(currentAccountIndex).get(2).equals(answer)){
            return true;
        }
        return false;
    }
    private boolean compareSecurityTwo(String answer){
        if (accountArray.get(currentAccountIndex).get(3).equals(answer)){
            return true;
        }
        return false;
    }
    private boolean compareSecurityThree(String answer){
        if (accountArray.get(currentAccountIndex).get(4).equals(answer)){
            return true;
        }
        return false;
    }
    /**
     * Check if the password meets requirements (8 char long, has upper letter, lower letter, and number)
     * by checking the ascii value of each character in the user's password
     *
     * @param  String password
     * @return boolean based on whether the password is correct or not
     */
    private boolean checkPasswordReq(String password){
        char character;
        boolean eightChar = false;
        boolean upperLetter = false;
        boolean lowerLetter = false;
        boolean number = false;

        if (password.length()>7){
            eightChar = true;
        }
        for (int i = 0; i < password.length(); i++){
            character = password.charAt(i);
            int ascii = character;

            if (ascii>64 && ascii<91){
                upperLetter = true;
            }
            if (ascii>96 && ascii<123){
                lowerLetter = true;
            }
            if (ascii>47 && ascii<58){
                number = true;
            }
        }
        if (eightChar && upperLetter && lowerLetter && number){
            return true;
        }
        return false;
    }
    // add friend to end of user's account array
    private void addFriend(String friendName){
        accountArray.get(currentAccountIndex).add(friendName);
    }
    /**
     * Searches through a user's account information to check whether the user has tried to friend themself
     * or is friending someone they are already friends with
     *
     * @param  String username of attempted friend
     * @return boolean true if the cases mentioned above are true
     */
    private boolean alreadyFriends(String username){
        boolean alreadyFriends = false;
        for (int i = 0; i< accountArray.get(currentAccountIndex).size(); i++){
            if (accountArray.get(currentAccountIndex).get(i).equals(username)){
                alreadyFriends = true;
            }
        }
        return alreadyFriends;
    }
    // for every change the user makes to their account, it gets printed to the csv file
    private void printChangesAccountsCSV(){
        try{
            FileWriter changes = new FileWriter("accounts.csv");

            // create header
            changes.append("Username, Password, Security One, Security Two, Security Three, Friends+");
            changes.append("\n");

            for (ArrayList<String> account: accountArray){
                for (String info: account){
                    changes.append(info + ", ");
                }
                changes.append("\n");
            }

            // closing statments in terminal
            changes.flush();
            changes.close();
            System.out.println("Changes printed to accounts.csv.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}