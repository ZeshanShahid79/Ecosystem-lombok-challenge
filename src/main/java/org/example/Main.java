package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("1", "Max", "Bahnhofsweg 4", 2);
        Student student2 = Student.builder()
                .id("2")
                .name("Hannah")
                .address("Goethe Str. 13")
                .grade(1)
                .build();


        Teacher teacher1 = new Teacher("123", "Mr. Smith", "Math");
        Teacher teacher2 = Teacher.builder()
                .id("456")
                .name("Mrs. Smith")
                .subject("English")
                .build();

        Teacher teacher3 = teacher1.withSubject("German");
        System.out.println(teacher3);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Course course = new Course("1001", "Mathematics 101", teacher1, students);
        Course course1 = Course.builder()
                .id("2002")
                .name("ffm-java-23-1")
                .teacher(teacher2)
                .students(students)
                .build();

        System.out.println(course);
        System.out.println(course1);
    }
}
