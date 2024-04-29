/**
 * UserController class instructs UserModel, WelcomeView, ProfileView, and MenuView objects
 * to take user inputs, validate inputs, and make changes to account information
 */

class UserController{
    private UserModel userModel;
    private WelcomeView welcomeView;
    private ProfileView profileView;
    private MenuView menuView;

    // constructor
    public UserController(UserModel userModel, WelcomeView welcomeView, ProfileView profileView, MenuView menuView){
        this.userModel = userModel;
        this.welcomeView = welcomeView;
        this.profileView = profileView;
        this.menuView = menuView;
    }
    // automatically tell userModel to load all accounts into 2D account array
    public void loadAccounts(){
        userModel.loadAccounts();
    }
    /**
     * Creates user account by taking input from welcomeView
     * Telling userModel to check if the inputs are valid
     * And moving the user to the menu screen once inputs are all correct
     * If something is wrong, a dialog box will the user what went wrong and recursion will
     * occur until user creates account properly
     *
     * @return String to move the user to the menu screen
     */
    public String createAccount(){
        String username = welcomeView.enterUsername();
        String password = welcomeView.enterPassword();
        String secOne = welcomeView.enterSecurityOne();
        String secTwo = welcomeView.enterSecurityTwo();
        String secThree = welcomeView.enterSecurityThree();

        String success = userModel.createAccount(username, password, secOne, secTwo, secThree);
        if (success.equals("failUsername")){
            welcomeView.usernameTaken();
            return createAccount();
        }
        else if (success.equals("failPassword")){
            welcomeView.passwordReq();
            return createAccount();
        }
        else{
            welcomeView.changesMade();
            success = "menu";
            return success;
        }
    }
    /**
     * Get username and password from WelcomeView
     * tell userModel to check if the user can log in or not
     * If user logged in correctly, they can move to menu screen
     * otherwise, they will be notified that they failed to log in
     * 
     * @return String to move to menu screen if user logs in correctly
     */
    public String logIn(){
        String username = welcomeView.enterUsername();
        String password = welcomeView.enterPassword();

        String success = "welcomeScreen";
        if (userModel.logIn(username, password)){
            success = "menu";
        }
        else {
            welcomeView.fieldWrong();
        }
        return success;
    }
    /**
     * get username and security input from welcomeView
     * tell userModel to validate
     * Tell the user their password if they pass security
     */
    public void forgotPassword(){
        String username = welcomeView.enterUsername();
        String secOne = welcomeView.enterSecurityOne();
        String secTwo = welcomeView.enterSecurityTwo();
        String secThree = welcomeView.enterSecurityThree();

        String password = userModel.forgotPassword(username, secOne, secTwo, secThree);
        if (password.equals("fail")){
            welcomeView.fieldWrong();
        }
        else {
            welcomeView.retrievedPassword(password);
        }
    }
    public void searchUser(){
        String username = menuView.enterUsername();

        if (userModel.searchUser(username)){
            menuView.userExist();
        }
        else{
            menuView.userNotExist();
        }
    }
    /**
     * Take user's current and new password
     * tell userModel to validate whether they are correct and meet password requirments
     * Let the user know if they successfully changed their password, or what mistake they made
     */
    public void changePassword(){
        String currentPassword = profileView.enterCurrentPassword();
        String newPassword = profileView.enterNewPassword();

        String success = userModel.changePassword(currentPassword, newPassword);
        if (success.equals("currentPassword")){
            profileView.currentPasswordWrong();
        }
        else if (success.equals("newPassword")){
            profileView.passwordReq();
        }
        else{
            profileView.changesMade();
        }
    }
    public void changeSecurity(){
        String secOne = profileView.enterSecurityOne();
        String secTwo = profileView.enterSecurityTwo();
        String secThree = profileView.enterSecurityThree();
        userModel.changeSecurity(secOne, secTwo, secThree);
        profileView.changesMade();
    }



    // private methods

    private String getUsername(){
        return userModel.getUsername();
    }
    private String getSecurityOne(){
        return userModel.getSecurityOne();
    }
    private String getSecurityTwo(){
        return userModel.getSecurityTwo();
    }
    private String getSecurityThree(){
        return userModel.getSecurityThree();
    }
}