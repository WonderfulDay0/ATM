package InputOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Output {
    private static String sourcePath = "phase2/main/files/";

    /**
     * Writes a single message to the file from the given path
     * @param message a String representing the message to be written
     * @param path a String representing the file path to write to
     * @param append a boolean to determine if we are appending to the file or not
     * */
    public static void write(String message, String path, boolean append) {
        try {
            File file = new File(sourcePath + path);
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, append));

            bw.write(message);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }


    public static void createNewDirectory(String name){
        try {
            File file = new File(sourcePath + name);
            file.mkdir();
//            file.createNewFile();
        }
        catch(Exception e) {
            System.out.println("File not created");
        }
    }
}
