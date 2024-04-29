/**
 * ImageController class instructs ImageModel and MenuView to load, display, and select new images
 */

class ImageController {
    private ImageModel imageModel;
    private MenuView menuView;

    // constructor
    public ImageController(ImageModel imageModel, MenuView menuView){
        this.imageModel = imageModel;
        this.menuView = menuView;
    }
    // tell imageModel to load all image paths from csv file
    public void loadImages(){
        imageModel.loadImagePaths();
    }
    /*
     * Tell imageModel to get the index of the newest image in the image array
     * take the path of that image
     * Tell menuView to display that image
     * 
     * If the newest image no longer exists, imageModel will index the image
     * preceding it and try to post that instead until it finally finds an image
     * that can be posted
     */
    public void displayImage(){
        int i = imageModel.getImageArrayLength()-1;
        String image = imageModel.getNextImage(i);
        boolean posted = menuView.displayImage(image);

        while (posted==false){
            i--;
            image = imageModel.getNextImage(i);
            posted = menuView.displayImage(image);
        }
    }
    /*
     * menuView will show user a dialog box that will allow them to select a new image to post
     * If the image exists, it will be added to the image array and csv file, otherwise
     * nothing will happen
     */
    public void selectNewImage(){
        String imagePath = menuView.dialogSelectImageFile();
        if (imagePath.equals("none")){
        }
        else{
            imageModel.updateImageArray(imagePath);
        }
    }
}