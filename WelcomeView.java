import javax.swing.JOptionPane;

/*
 * WelcomeView class takes user credentials (username, password, security) from dialog boxes
 * and will notify a user if their credentials are valid or do not meet the requirements
 * based on the UserModel's response
 */

class WelcomeView{

    // constructor
    public WelcomeView(){
    }

    // methods that take and return user credentials to the UserController through dialog box
    public String enterUsername(){
        String user = JOptionPane.showInputDialog("Enter username: ");
        return user;
    }
    public String enterPassword(){
        String password = JOptionPane.showInputDialog("Enter password with at least 8 characters, a number, capital letter, and lowercase letter.");
        return password;
    }
    public String enterSecurityOne(){
        String securityOne = JOptionPane.showInputDialog("What planet are you from?");
        return securityOne;
    }
    public String enterSecurityTwo(){
        String securityTwo = JOptionPane.showInputDialog("What is your favourite food?");
        return securityTwo;
    }
    public String enterSecurityThree(){
        String securityThree = JOptionPane.showInputDialog("What is your favourite book or movie?");
        return securityThree;
    }

    // methods that notify the user of the validity of their credentials with message dialog boxes
    public void usernameTaken(){
        JOptionPane.showMessageDialog(null, "This username is taken", "Unavailable", JOptionPane.INFORMATION_MESSAGE);
    }
    public void passwordReq(){
        JOptionPane.showMessageDialog(null,"Your password must contain: at least 8 characters, a special character, uppercase letter, and lowercase letter", "Warning", JOptionPane.ERROR_MESSAGE);
    }
    public void changesMade(){
        JOptionPane.showMessageDialog(null, "Changes have been made", "Changes", JOptionPane.INFORMATION_MESSAGE);
    }
    public void retrievedPassword(String password){
        JOptionPane.showMessageDialog(null, "Here is your password: " + password, "Password", JOptionPane.INFORMATION_MESSAGE);
    }
    public void fieldWrong(){
        JOptionPane.showMessageDialog(null, "A field is wrong", "Error", JOptionPane.ERROR_MESSAGE);
    }
}