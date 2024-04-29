import javax.swing.filechooser.FileFilter;
import java.io.File;

/*
 * ImageFilter class is used by MenuView to make sure users can only select jpeg jpg or png images to post
 */

class ImageFilter extends FileFilter {
    // image types allowed to be selected
    String JPEG = "jpeg";
    String JPG = "jpg";
    String PNG = "png";

    // take an image file
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        // check extension to ensure it is jpeg jpg png
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals(JPEG) ||
                extension.equals(JPG) ||
                extension.equals(PNG)) {
                return true;
            } 
            else {
                return false;
            }
        }
        return false;
    }
    // if user selects non-image
    public String getDescription() {
        return "Image Only";
    }
    // send extension of file to accept() method so it can check whether file type is allowed
    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}