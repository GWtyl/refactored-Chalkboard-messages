import java.io.*;
import java.util.*;

 class CheckMessages {
	
	BufferedReader br = null;
	//stores the messages between 2 people
	 protected static File messageCSV;
	 private static File Messaging(){
		String userPathway = System.getProperty("user.dir");
		 messageCSV = new File(userPathway+"\\messages.csv");
		return messageCSV;
	 }
	    



		


}
