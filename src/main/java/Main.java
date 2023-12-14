import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String location = "src/main/resources/";
        Person person = new Person("Test", "test", 123);

        String pathToFile;
        try {
            pathToFile = SerializeUtil.saveToFile(person, location);
            Person loadedPerson = (Person) SerializeUtil.loadFromFile(pathToFile);
            System.out.println(loadedPerson);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
