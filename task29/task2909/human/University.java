package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();

    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade)
                return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade = 0;
        int index = 0;


        for (Student student : students) {

            if (student.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
                index = students.indexOf(student);
            }
        }

        return students.get(index);
    }

    public Student getStudentWithMinAverageGrade() {

        double minGrade = 100;
        int index = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minGrade) {
                minGrade = students.get(i).getAverageGrade();
                index = i;
            }
        }

        return students.get(index);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}