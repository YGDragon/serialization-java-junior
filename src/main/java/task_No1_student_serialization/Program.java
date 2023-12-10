package task_No1_student_serialization;

import java.io.*;

public class Program {
    public static void main(String[] args) {

        Student student = new Student("Николай", 19, 7.5);
        serializeToFile(student);
        System.out.println(deserializeFromFile());
    }

    public static String pathFile = "src\\main\\resources\\file-serialize.bin";

    public static <T> void serializeToFile(T clazz) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathFile)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserializeFromFile() {
        try (FileInputStream fileInputStream = new FileInputStream(pathFile)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
