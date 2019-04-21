package InputOutput;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ReaderText {
    private static String sourcePath = "phase2/main/files/";

    /**
     * Reads alerts.txt and returns which bills need restocking
     * @param path a String representing the file path to write to
     * @return a boolean array representing which bills need to be restocked
     */
    public static boolean[] readAlerts(String path) {
        boolean[] stockArray = new boolean[5];

        try {
            File file = new File(sourcePath + path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                int tempLine = Integer.parseInt(line.trim());

                switch (tempLine) {
                    case 5:
                        stockArray[0] = true;
                        break;
                    case 10:
                        stockArray[1] = true;
                        break;
                    case 20:
                        stockArray[2] = true;
                        break;
                    case 50:
                        stockArray[3] = true;
                        break;
                    case 100:
                        stockArray[4] = true;
                        break;
                    default:
                        break;
                }
            }

            if (file.delete())
                if (file.createNewFile())
                    System.out.println("Successful file creation!");
                else
                    System.out.println("File already exists!");
            else
                System.out.println("File not deleted!");

            br.close();
        } catch (IOException e) {
            System.out.print("File not found!");
            e.printStackTrace();
        }

        return stockArray;
    }

    /**
     * Reads from accID.txt or transID.txt and returns the ID
     * @param path a String representing the file path to write to
     * @return an int representing the up-to-date account or transaction ID
     */
    public static int readID(String path) {
        int id = 0;

        try {
            File file = new File(sourcePath + path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            if (line != null)
                id = Integer.parseInt(line.trim());
            else
                System.out.println("Unable to convert to integer!");

            br.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return id;
    }

    public static String[] readEmployeeInfo(String path) {
        String[] info = new String[2];

        try {
            File file = new File(sourcePath + path);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            int i = 0;
            while ((line = br.readLine()) != null) {
                info[i] = line.trim();
                i++;
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return info;
    }
}