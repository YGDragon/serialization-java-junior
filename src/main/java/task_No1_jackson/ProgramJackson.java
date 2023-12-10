package task_No1_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import task_No1_student_serialization.Student;

import java.io.*;

public class ProgramJackson {
    public static void main(String[] args) {
        Student student = new Student("Федор", 22, 8.3);
        convertToJson(student);
        System.out.println(convertFromJson());
    }

    public static String pathFile = "src\\main\\resources\\student-serialize.json";

    public static <T> void convertToJson(T clazz) {
        try (FileWriter fileWriter = new FileWriter(pathFile)) {
            fileWriter
                    .write(
                            new ObjectMapper().writeValueAsString(clazz)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object convertFromJson() {
        try {
            return new ObjectMapper().readValue(new File(pathFile), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}