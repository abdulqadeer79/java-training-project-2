import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFileCreator {
    public static void main(String[] args) {
        // create file and then write to that file.
        try {
            File myFile = new File("/Users/aqadeer/Desktop/java-training-project-2/create-file/test.txt");
            if (myFile.createNewFile() || myFile.length() == 0) {
                System.out.println("File created " + myFile.getName());
            }
            else {
                System.out.println("File already exists");
            }

        } catch (IOException ex) {
            System.out.println("exception thrown");

        }
    }
}
