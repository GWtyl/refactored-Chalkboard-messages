import java.util.Scanner;

/**
 * @author      Joshua, Alyson, Miki
 * @version     Chalkboard Message Culminating Program
 * @since       May 25 - June 12, 2023
 */

class AlysonJoshuaMikiChalkboard {
    public static void main(String[] args) {

        // create objects
        UserModel userModel = new UserModel();
        ImageModel imageModel = new ImageModel();

        WelcomeView welcomeView = new WelcomeView();
        ProfileView profileView = new ProfileView();
        MenuView menuView = new MenuView();

        UserController userController = new UserController(userModel, welcomeView, profileView, menuView);
        ImageController imageController = new ImageController(imageModel, menuView);

        Scanner scanner = new Scanner(System.in);

        // load data
        userController.loadAccounts();
        imageController.loadImages();

        // screen status
        Gui.Screens();
        String screen = "welcomeScreen";

        while (screen.equals("welcomeScreen")){
            System.out.println("Press 1 to log in");
            System.out.println("Press 2 to create account");
            System.out.println("Press 3 to retrieve forgotten password");
            String request = scanner.nextLine();

            if (request.equals("1")){
                screen = userController.logIn();     // move to menu depending on successful log in
            }
            else if (request.equals("2")){
                screen = userController.createAccount();      // move to menu if successfully create account (recursion)
            }
            else if (request.equals("3")){
                userController.forgotPassword();           // answer security questions correctly to access your password
            }
            else{}
        }
        while (screen.equals("menu")){
            imageController.displayImage();
            System.out.println("Press 1 to search for friends");
            System.out.println("Press 2 to go to profile");
            System.out.println("Press 3 to post another image");
            String request = scanner.nextLine();

            if (request.equals("1")){
                userController.searchUser();                  // search for friends
            }
            else if (request.equals("2")){
                screen = "profile";                      // move to profile
            }
            else if (request.equals("3")){
                imageController.selectNewImage();          // select another image to post
            }
            else{}
        }
        while (screen.equals("profile")){
            System.out.println("Press 1 to change password");
            System.out.println("Press 2 to change security");
            System.out.println("Press 3 to quit");
            String request = scanner.nextLine();

            if (request.equals("1")){
                userController.changePassword();        // enter current password to change new password
            }
            else if (request.equals("2")){
                userController.changeSecurity();      // enter new security answers
            }
            else if(request.equals("3")){
                screen = "done";                         // log out
            }
            else{}
        }
        scanner.close();
        System.out.println("FINISHED");
    }
}