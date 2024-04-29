import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
//import javax.swing.text.View;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class Gui extends CheckMessages{

    static Font f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 11); // for regular texting
    static Font f2 = new Font(Font.SERIF, Font.ITALIC, 30); //for name of our app
    private static JFrame frame = new JFrame("ChalkBoard Message"); //declare a window to work with
    static Color snow = new Color(255,250,250); //create a color called snow  
    private static CardLayout cardLayout = new CardLayout();
    private static JPanel cardPanels = new JPanel(cardLayout);
    private static JPanel frame1;
    private static JPanel frame2;
    private static JPanel frame3;
    private static JPanel frame4;
    private static JPanel frame5;
    private static JPanel frame6;
    
    //properties of the window
    static void FrameProperties(){
        frame.setVisible(true); // makes the window visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminates application upon closing
        frame.setSize(900,650); //set size for window
        frame.setLayout(null);//not using any layout managers
        frame.setResizable(false); //disable resizing the window
        cardPanels.setBounds(0, 0, 900, 600);//set the size of the window
        frame.getContentPane().add(cardPanels);//add the panels to the window
    }

    //create multiple functions that store each frame of the program
    static void frame1(){
        frame1 = new JPanel();
        frame1.setLayout(null);
        cardPanels.add(frame1,"1");
    }
    static void frame2(){
        frame2 = new JPanel();
        frame2.setLayout(null);
        cardPanels.add(frame2,"2");

    }
    static void frame3(){
        frame3 = new JPanel();
        frame3.setLayout(null);
        cardPanels.add(frame3,"3");

    }
    static void frame4(){
        frame4 = new JPanel();
        frame4.setLayout(null);
        cardPanels.add(frame4,"4");
    }
    static void frame5(){
        frame5 = new JPanel();
        frame5.setLayout(null);
        cardPanels.add(frame5,"5");
    }
    static void frame6(){
        frame6 = new JPanel();
        frame6.setLayout(null);
        cardPanels.add(frame6,"6");
    }

    //This is the screen that the user first interacts with, where you can log in, reset password, or create account
    static void WelcomeScreen(){
        JLabel name = new JLabel(" ChalkBoard Messages"); //name of our app
        JTextField username = new JTextField(); //for users to type the username
        JLabel usernametxt = new JLabel("Username"); //indication of username
        JLabel passwordtxt = new JLabel("Password"); // indication of password
        JPasswordField password = new JPasswordField(); //for users to type their password
        JButton logIn = new JButton("Log In");//button for log in
        JButton newAccount = new JButton("Create Account"); //button for creating new account
        JButton forgotPassword = new JButton("Forgot Password?");// button for retriving password 
        
        //set the font
        name.setFont(f2);
        logIn.setFont(f1);
        newAccount.setFont(f1);
        forgotPassword.setFont(f1);

        //set the position/size of the buttons/texts
        name.setBounds(300,100,300,100);
        username.setBounds(300,200, 300, 25);
        password.setBounds(300,250, 300, 25);
        logIn.setBounds(350, 300, 200,50);
        newAccount.setBounds(350,375, 200, 50);
        usernametxt.setBounds(200,200,100,25);
        passwordtxt.setBounds(200, 250, 100, 25);
        forgotPassword.setBounds(350, 450, 200, 50);

        frame1(); //initialize frame 1
        //add everything into the frame
        frame1.add(name);
        frame1.add(username);
        frame1.add(password);
        frame1.add(logIn);
        frame1.add(newAccount);
        frame1.add(usernametxt);
        frame1.add(passwordtxt);
        frame1.add(forgotPassword);

        FrameProperties();// properties from the window

        //checks if user presses the log in button
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){  
                cardLayout.show(cardPanels, "4");
                username.setText("");
                password.setText("");
            }
        });

        //takes user to account creation screen when pressed
        newAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"3");
            }
        });

        //takes user to forgot password screen when presssed
        forgotPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"2");
            }
        });

    }
    //This panel is for users when they wnat to reset their passwords
    static void ResetPassword(){
        JLabel Q1 = new JLabel("Question 1");//label for question 1
        JLabel Q2 = new JLabel("Question 2");//label for question 2
        JLabel Q3 = new JLabel("Question 3");//label for question 3
        JTextField A1 = new JTextField();//answer for question 1
        JTextField A2 = new JTextField();//answer for question 2
        JTextField A3 = new JTextField();//answer for question 3
        JButton back = new JButton("Back");//creates a button to take user back to the welcome screen
        JLabel newPasswordtxt = new JLabel("Enter new password");//text for resetting password
        JLabel confirmNewPasswordtxt = new JLabel("Enter the new password again");//text for re-entering the new passowrd
        JTextField newPassword = new JTextField();//creates space for user to type in the new password
        JTextField confirmNewPassword = new JTextField();//creates space for user to re-enter the new password
        JButton reset = new JButton("Reset password");//creates a button to reset the password

        Q1.setBounds(300, 50, 200, 50);
        A1.setBounds(300, 100, 200, 25);
        Q2.setBounds(300, 150, 200, 50);
        A2.setBounds(300, 200, 200, 25);
        Q3.setBounds(300,250,200,50);
        A3.setBounds(300,300,200,25);
        back.setBounds(0, 0, 100, 50);
        newPasswordtxt.setBounds(300,350,200,50);
        newPassword.setBounds(300,400,200,25);
        confirmNewPasswordtxt.setBounds(300, 450, 200, 50);
        confirmNewPassword.setBounds(300, 500, 200, 25);
        reset.setBounds(600,250,150,50);
        
        frame2();
        frame2.add(Q1);
        frame2.add(Q2);
        frame2.add(Q3);
        frame2.add(A1);
        frame2.add(A2);
        frame2.add(A3);
        frame2.add(back);
        frame2.add(newPassword);
        frame2.add(newPasswordtxt);
        frame2.add(confirmNewPassword);
        frame2.add(confirmNewPasswordtxt);
        frame2.add(reset);
        FrameProperties();

        //Once pressed the reset button, the password is supposesedly resetted and takes the user back to the welcome screen
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"1");
            }
        });
        
        //pressing the back button will take the user back to the welcome screen, and their changes will be unsaved
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"1");
            }
        });
    }
    
    //this is the screen where users are taken to create a account
    static void AccountCreation(){
        JTextField username = new JTextField();//creates a area for user to type in a username of their choice
        JPasswordField password = new JPasswordField();//creates a safe space for users to type their new password
        JLabel usernametxt = new JLabel("Username");//creates the text for the username
        JLabel passwordtxt = new JLabel("Password");//creates the text for the password
        JButton signUp = new JButton("Sign Up");//creates a button for signing up a account
        JButton logIn = new JButton("Log In");//creates a button to take user back to the log in screen
        JLabel logIntxt = new JLabel("Already signed up? Log in here");//creates text that informs user about logging in
        JLabel Q1 = new JLabel("Which planet are you from?");//text for question 1
        JTextField A1 = new JTextField();//creates a space for the answer for question 1
        JLabel Q2 = new JLabel("What is your favourite food?");//text for question 2
        JTextField A2 = new JTextField();//creates a space for the answer for question 2
        JLabel Q3 = new JLabel("What is your favourite book or movie?");//text for question 3
        JTextField A3 = new JTextField();//creates a space for the answer for question 3
        
       

        //set the position of everything
        username.setBounds(300, 100, 300, 25);
        password.setBounds(300,150,300, 25);
        usernametxt.setBounds(200, 100 ,100, 25);
        passwordtxt.setBounds(200,150,100,25);
        Q1.setBounds(100, 200, 200, 25);
        A1.setBounds(300, 200, 300, 25);
        Q2.setBounds(100, 250, 200, 25);
        A2.setBounds(300, 250, 300, 25);
        Q3.setBounds(50, 300, 250, 25);
        A3.setBounds(300,300,300,25);
        signUp.setBounds(395,500,100,30);
        logIn.setBounds(395,400,100,30);
        logIntxt.setBounds(370, 375, 200, 25);

        frame3();//initialize frame3
        //add everything to the window
        frame3.add(username);
        frame3.add(password);
        frame3.add(usernametxt);
        frame3.add(passwordtxt);
        frame3.add(signUp);
        frame3.add(logIn);
        frame3.add(logIntxt);
        frame3.add(Q1);
        frame3.add(Q2);
        frame3.add(Q3);
        frame3.add(A1);
        frame3.add(A2);
        frame3.add(A3);
        FrameProperties();// properties from the window

        //this will listen to the action that occurs to signup button. if the sign up button is clicked
        //the screen will be switched to the Home screen
        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"4");
            }
        });

        //This will listen to the action that occurs to the logIn button. if the logIn button is clicked
        //the screen will switch to the Welcome screen
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"1");
            }
        });
    }

    //this is the home screen where users can message, upload image, and change their password/security question
    static void MainScreen(){

        //gets the local time from the computer
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm");
        LocalDateTime time =  LocalDateTime.now();

        File file = new File("C:\\");//creates a file with the file path

        //the buttons will be changed to icons later
        JButton post = new JButton("Post");//create post
        JButton message = new JButton("Message"); //send message
        JButton userProfile = new JButton("User Profile"); //check userprofile
        JButton search = new JButton("Search Users..."); //search for users
        JButton logOut = new JButton("Log out");//log out of user's account
        JLabel displayTime = new JLabel(format.format(time));//displays the time
        JButton home = new JButton("Home");//home button
        JPanel panel = new JPanel();//where the post goes
        JPanel tools = new JPanel();//where log out, post, search user, and send messages are located
        JScrollPane extendedPost = new JScrollPane(panel);//scroll wheel for the posts

        //set dimensions for everything
        post.setBounds(300, 555, 75, 50);
        logOut.setBounds(150, 555, 75, 50);
        search.setBounds(400,555,300,50);
        message.setBounds(725,555,125,50);
        userProfile.setBounds(25,25, 125,50);
        home.setBounds(25,555,75,50);
        displayTime.setBounds(600,25,100,25);
        panel.setBackground(snow);//change the color of the panel to color: snow
        tools.setBounds(0, 550, 900, 100);
        tools.setBackground(snow);
        extendedPost.setBounds(400,100,300,350);
        extendedPost.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        frame4(); //initalize frame4

        //add everything to frame4
        frame4.add(post);
        frame4.add(logOut);
        frame4.add(search);
        frame4.add(message);
        frame4.add(userProfile);
        frame4.add(displayTime);
        frame4.add(home);
        frame4.add(tools);
        frame4.add(extendedPost);

        FrameProperties();// properties from the window

        //listens to the action to the post button. If it is pressed a dialog box will be opened
        //and the user can chose the file to upload from their computer
        post.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                    JFileChooser fileChooser = new JFileChooser();
                    int option = fileChooser.showOpenDialog(extendedPost);
                    File file = fileChooser.getSelectedFile();
            }
        });
        
        //If the user presses the message button they will be taken to the message screen where they
        //are able to message their friends
        message.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"6");
                frame.revalidate();
            }
        });

        //If the user pressed the logOut button, then they will be taken to the log in screen
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"1");
                frame.revalidate();
            }
        });
        
        //If the user presses the userProfile button, then they will be taken to their user profile
        userProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"5");
                frame.revalidate();
            }
        });


    }

    //the profile window where you can see your personal profile
    static void ViewAccount(){
        JLabel username = new JLabel("Username");//creates the label for username
        JLabel security = new JLabel("Security questions");//create the label for security questions
        JLabel Q1 = new JLabel("Question1: Answer1");//creates the label for question 1
        JLabel Q2 = new JLabel("Question2: Answer2");//creates the label for question 2
        JLabel Q3 = new JLabel("Question3: Answer3");//creates the label for question 3
        JButton newPassword = new  JButton("Change Password");//creates the button to change passwords
        JButton newQuestion = new JButton("Change Security Questions");//creates the button to change security questions
        JButton back = new JButton("Back");//goes back to main menu


        //set the dimensions for everything
        username.setBounds(400,100,150,50);
        security.setBounds(375, 150, 150, 50);
        Q1.setBounds(375, 200, 150, 50);
        Q2.setBounds(375, 225, 150, 50);
        Q3.setBounds(375, 250, 150, 50);
        newPassword.setBounds(360, 300, 150, 50);
        newQuestion.setBounds(340, 375, 200, 50);
        back.setBounds(0, 0, 75, 50);

        frame5();//initalize frame5
        //adds everything to frame5
        frame5.add(username);
        frame5.add(security);
        frame5.add(Q1);
        frame5.add(Q2);
        frame5.add(Q3);
        frame5.add(newPassword);
        frame5.add(newQuestion);
        frame5.add(back);

        FrameProperties();//gets all the properties from the frame

        //if back button is pressed the screen will switch to the home screen
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                cardLayout.show(cardPanels,"4");
                frame.revalidate();
            }
        });

    }

    //method that allows for messaging
    static void Messaging(){
        JTextArea chat = new JTextArea();//creates a textArea that displays the text
        JScrollPane scrollPane = new JScrollPane(chat);//adds chat to the scrollPane
        JTextField input = new JTextField();//input of user
        JButton send = new JButton("Send"); // send button
        JButton back = new JButton("Back");//creates the back button

        chat.setEditable(false);//makes the chat uneditable
        
        //set the dimensions for everything
        scrollPane.setBounds(150, 0, 500, 550);
        input.setBounds(149, 550, 400, 25);
        send.setBounds(550, 550, 100,25);
        back.setBounds(0, 0, 100,50);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//creates a permanent scrollbar

        frame6(); //initiate frame6
        //add everything to the frame6    
        frame6.add(scrollPane);
        frame6.add(input);
        frame6.add(send);
        frame6.add(back);

        FrameProperties();// properties from the window

        //allows pressing the send button the send the message
        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                try{
                FileWriter writer = new FileWriter(messageCSV);
                String message = input.getText();
                CheckMessages store = new CheckMessages();
                
                chat.append("You: "+ message+" \n");
                input.setText("");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        //pressing the back button will switch to MainScreen() frame
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanels,"4");
            } 
        });
        
    }
    //puts all the frames within 1 method for easy access
    static void Screens(){
        WelcomeScreen();
        ResetPassword();
        AccountCreation();
        MainScreen();
        ViewAccount();
        Messaging();
    }
}
