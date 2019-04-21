package InputOutput;

import java.io.*;

public class Serialization {
    private static String sourcePath = "phase2/main/files/";

    /**
     * Serializes a given bank manager.
     * @param obj - the object that is being serialized
     * @param filename - the name of the file that the file output stream belongs to
     */
    public static void serializeObject(Object obj, String filename) {
        // Serialization - Writing
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(sourcePath + filename, false);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(obj);
            out.close();
            file.close();

        } catch (NotSerializableException ex){
            System.out.println("NotSerializableException is caught");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Deserialize a given object.
     * @param filename - the name of the file that the file output stream belongs to
     * @return Object - the object that is being desrialized
     */
    public static Object deserializeObject(String filename) {
        Object object1 = null;

        // Deserialization
        try {
            FileInputStream file = new FileInputStream(sourcePath + filename);
            ObjectInputStream in = new ObjectInputStream(file);

            object1 = in.readObject();

            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException is caught");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        return object1;
    }

}
