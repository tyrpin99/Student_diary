package com.company;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;


public class Class {
    public String groupName;
    public ArrayList<Student> studentList;
    public int studentMax;

    public Class(String groupName,int studentMax){
        this.groupName = groupName;
        this.studentList = new ArrayList<>();
        this.studentMax = studentMax;

    }
    public void addStudent(Student student) {
        if (studentList.size() + 1 == studentMax) {
            System.out.println("Class is full !");
        } else {
            studentList.add(student);
        }
    }
        public void addPoints(Student student, double points)
        {
            student.points += points;
        }
        public void getStudent(Student student){
    if(student.points == 0)
        studentList.remove(student);

    else
        student.points -= 1 ;
    }
    public void changeCondition(Student student , StudentCondition studentCondition){
        student.studentCondition = studentCondition;
    }
    public void removePoints(Student student, double points){
        if ((student.points - points) <=0){
            System.out.println("Deleting student");
            studentList.remove(student);
        }
        else
            student.points -= points;
    }
    public Student searchSurr(String surrname){
        Comparator<Student> s = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.surrname.compareTo(o2.surrname);
            }
        };
        int index = Collections.binarySearch(studentList,new Student(null,surrname,null,0,0));
        System.out.println(studentList.get(index));
        return studentList.get(index);
    }

    public void searchPartial(String part){

        String part2 = part.toLowerCase();
        for(int i=0 ; i<studentList.size();i++){
            boolean name = studentList.get(i).name.toLowerCase().contains(part2);

            boolean surrname = studentList.get(i).surrname.toLowerCase().contains(part2);
            if((name == true) || (surrname == true)){
                System.out.println(studentList.get(i));
            }


        }
        }


    public int countByCondition(StudentCondition studentCondition){
        int number= 0;
        for(int i=0; i <studentList.size();i++)
        {
            if(studentList.get(i).studentCondition == studentCondition)
                number += 1;
        }
       return number;
    }

    public void summary(){
        System.out.println(studentList);
    }
    public void sortByName(){
        Collections.sort(studentList);
    }
    public void sortByPoints(){
       Collections.sort(studentList, new Comparator<Student>() {
           @Override
           public int compare(Student o1, Student o2) {
               return (int) (o2.points -o1.points);
           }
       });


    }
    public void max(){
        Collections.max(studentList);
    }

}
