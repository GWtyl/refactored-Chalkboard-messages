import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * MenuView class can take usernames of potential friends and show user dialog box of whether they are able to add that friend or not
 * It can also let the user select an image file to post and then display that image on the menu screen
 */

class MenuView {

    // constructor
    public MenuView(){
    }
    // add friend dialog boxes
    public String enterUsername(){
        String user = JOptionPane.showInputDialog("Enter username: ");
        return user;
    }
    public void userNotExist(){
        JOptionPane.showMessageDialog(null, "This user does not exist.", "Can't find friends", JOptionPane.INFORMATION_MESSAGE);
    }
    public void userExist(){
        JOptionPane.showMessageDialog(null, "Friend added.", "New friend", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Dialog box lets users choose an image from their drive (JPG JPEG PNG)
     *
     * @return String of the selected image's path
     */
    public String dialogSelectImageFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new ImageFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelled", "Image Selection", JOptionPane.INFORMATION_MESSAGE);
            return "none";
        }
    }
    /**
     * Takes the path of the selected image and displays it on menu screen if it exists
     * Otherwise, a dialog box will appear to let the user know that image does not exist, or no longer exists
     *
     * @param  String image path
     * @return boolean true if image can be displayed or false to let the program know to display the previous existing image
     */
    public boolean displayImage(String path){
        File imagePath = new File(path);

        if (imagePath.exists()){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Image does not exist.", "Image Selection", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}