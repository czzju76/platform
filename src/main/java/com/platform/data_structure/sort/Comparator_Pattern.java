package com.platform.data_structure.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1、在实际项目中，我们不会自己编写排序功能，而使用系统提供的排序方法。
 * 2、Arrays.sort()方法可以直接对基础数据类型进行排序，如果要对Object类型排序，需要利用Comparator接口
 * 3、工程中使用接口Comparator（提供两个Object比较的方法），用来对Object类型进行排序
 *
 */

public class Comparator_Pattern {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    public static class IdDescendingComparator implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }

    public static class AgeAscendingComparator implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }

    }

    public static class AgeDescendingComparator implements Comparator<Student> {

        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }

    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new AgeDescendingComparator());
        printStudents(students);

    }
}
