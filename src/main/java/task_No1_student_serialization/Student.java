package task_No1_student_serialization;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long SerialVersionUID = 1L;

    //region Methods
    @Override
    public String toString() {
        return "Имя->{" + getName() + "}\n"
                + "Возраст->{" + getAge() + "}\n"
                + "Средний бал->{" + getGPA() + "}\n";
    }
    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    //endregion

    //region Fields
    private String name;
    private int age;
    private transient double GPA;
    //endregion

    //region Constructors
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }

    ;
    //endregion
}
