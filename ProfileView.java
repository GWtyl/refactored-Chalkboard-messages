import javax.swing.JOptionPane;

/**
 * ProfileView class will receive password and security inputs to either change passwords
 * or security answers
 * It also contains the dialog boxes to let the user know if they were successful or not
 */

class ProfileView {

    // constructor
    public ProfileView(){
    }

    // getters
    public String enterCurrentPassword(){
        String password = JOptionPane.showInputDialog("Enter current password: ");
        return password;
    }
    public String enterNewPassword(){
        String password = JOptionPane.showInputDialog("Enter new password with at least 8 characters, a number, capital letter, and lowercase letter.");
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

    // notify user with dialog boxes
    public void currentPasswordWrong(){
        JOptionPane.showMessageDialog(null, "You entered CURRENT password incorrectly.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void passwordReq(){
        JOptionPane.showMessageDialog(null,"NEW password must contain: at least 8 characters, a special character, uppercase letter, and lowercase letter", "Warning", JOptionPane.ERROR_MESSAGE);
    }
    public void changesMade(){
        JOptionPane.showMessageDialog(null, "Changes have been made", "Changes", JOptionPane.INFORMATION_MESSAGE);
    }
    public void fieldWrong(){
        JOptionPane.showMessageDialog(null, "A field is wrong", "Error", JOptionPane.ERROR_MESSAGE);
    }
}