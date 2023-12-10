package task_No1_xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import task_No1_student_serialization.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProgramXml {
    public static void main(String[] args) {
        Student student = new Student("Федор", 22, 8.3);
        convertToXml(student);
        System.out.println(convertFromXml());
    }

    public static String pathFile = "src\\main\\resources\\student-serialize.xml";

    public static <T> void convertToXml(T clazz) {
        try (FileWriter fileWriter = new FileWriter(pathFile)) {
            fileWriter
                    .write(
                            new XmlMapper().writeValueAsString(clazz)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object convertFromXml() {
        try {
            return new XmlMapper().readValue(new File(pathFile), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}