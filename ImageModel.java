import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

/**
 * ImageModel class automatically loads the array of images to be accessed and posted later
 * It will also update and print the array everytime the user selects another image to display
 */

class ImageModel {
    private ArrayList<String> imagePathArray;

    // constructor
    public ImageModel(){
        imagePathArray = new ArrayList<String>();
    }
    /**
     * When creating account for the first time, defaultpost.jpg will be added to the
     * array of images and automatically be posted
     * If images.csv file exists and is populated, BufferedReader will read each
     * image path and add it to the array of images
     */
    public void loadImagePaths(){
        String currentDirectory = System.getProperty("user.dir");
        String defaultImagePath = currentDirectory + "/defaultpost.jpg";
        imagePathArray.add(defaultImagePath);

        File imagesCSV = new File(currentDirectory + "/images.csv");

        if (imagesCSV.exists()){
            BufferedReader bufferedReader = null;
            try {		
                bufferedReader = new BufferedReader(new FileReader("images.csv"));		
                String imagePath = bufferedReader.readLine();

                while (imagePath != null) {
                    imagePathArray.add(imagePath);
                    imagePath = bufferedReader.readLine();
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
    // getters
    public int getImageArrayLength(){
        return imagePathArray.size();
    }
    public String getNextImage(int i){
        return imagePathArray.get(i);
    }
    // take a new image path and add it to image array and csv file
    public void updateImageArray(String path){
        updateArray(path);
        printChangesImageCSV();
    }



    // private helper methods to add new images

    private void updateArray(String path){
        imagePathArray.add(path);
    }
    private void printChangesImageCSV(){
        try{
            FileWriter print = new FileWriter("images.csv");

            // skip default post image
            for (int i = 1; i<imagePathArray.size(); i++){
                print.append(imagePathArray.get(i) + "\n");
            }

            // closing statments in terminal
            print.flush();
            print.close();
            System.out.println("Changes printed to images.csv.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}