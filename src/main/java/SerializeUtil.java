import java.io.*;
import java.util.UUID;

public class SerializeUtil {

    public static String saveToFile(Serializable object, String filePath) throws IOException {
        String fullPath = filePath + object.getClass().getSimpleName() + "_" + UUID.randomUUID();
        File file = new File(fullPath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileOutputStream outputStream = new FileOutputStream(fullPath);
             ObjectOutputStream objectOut = new ObjectOutputStream(outputStream)) {
            objectOut.writeObject(object);
            objectOut.close();
            System.out.println("The Object was successfully written to a file");
        } catch (IOException e) {
            System.out.println("Problems with writing to a file.");
            e.printStackTrace();
        }
        return fullPath;
    }

    public static Object loadFromFile(String filePath) {
        Object ob = null;
        try (FileInputStream inputStream = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(inputStream);) {
            ob = objectIn.readObject();
            System.out.println("The Object was successfully read from a file");
            File toDelete = new File(filePath);
            toDelete.deleteOnExit();
        } catch (IOException e) {
            System.out.println("Problems with loading reading a file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ob;
    }
}
