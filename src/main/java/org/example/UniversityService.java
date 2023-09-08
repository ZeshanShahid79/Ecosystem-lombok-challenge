package org.example;

import java.util.List;

public class UniversityService {

    public double calculateAverageCourseGrade(Course course) {
        List<Student> students = course.getStudents();
        double totalGrade = students.stream()
                .mapToDouble(Student::getGrade)
                .sum();
        return totalGrade / students.size();
    }

    public double calculateAverageUniversityGrade(University university) {
        List<Student> allStudents = university.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .toList();

        double totalGrade = allStudents.stream()
                .mapToDouble(Student::getGrade)
                .sum();

        return totalGrade / allStudents.size();
    }

    public List<Student> findGoodStudents(University university) {
        return university.getCourses().stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getGrade() >= 2.0)
                .toList();
    }
}
