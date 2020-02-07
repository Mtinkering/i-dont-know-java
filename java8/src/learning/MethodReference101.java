package learning;

import java.io.File;

/**
 * // TODO Comment
 */
public class MethodReference101 {
    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    }
}
