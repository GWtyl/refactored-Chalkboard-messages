import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SendMessage extends CheckMessages {
    public SendMessage() throws IOException{}

    BufferedReader br = null;
    FileWriter writer = new FileWriter(messageCSV);
    int Id = 0;
    ArrayList<String> IDStorage = new ArrayList<>();
    UserModel user = new UserModel();
    int counter = 0;


    
     void sendMessage() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        writer.write(IDStorage.get(0));
        writer.write(br.readLine());
    }

    static void checkID(){ //checks if a conversation has already been started 
        
    }
}
