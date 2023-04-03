package com.company;

import java.util.UUID;

public class Student implements Comparable<Student> {
    String name;
    String surrname;
    StudentCondition studentCondition;
    int year;
    double  points; 

    public Student(String name,String surrname, StudentCondition studentCondition, int year, double points)
    { 
        this.name = name;
        this.surrname = surrname;
        this.studentCondition = studentCondition;
        this.year = year;
        this.points = points;
    }
    public void print(){
        System.out.println("Name: " +name);
        System.out.println("Surrname: " +surrname);
        System.out.println("Student Condition: " +studentCondition);
        System.out.println("Year: " +year);
        System.out.println("Points: " +points);

    }

    @Override
    public int compareTo(Student o) {
        int result = this.surrname.compareTo(o.surrname);
        return result;
    }


    @Override
    public String toString() {
        return "Student{" +
                "Name ='" + name + '\'' +
                ", Surrname='" + surrname + '\'' +
                ", StudentState=" + studentCondition +
                ", YearOfBirth =" + year +
                ", Points=" + points +
                '}';
    }
}

