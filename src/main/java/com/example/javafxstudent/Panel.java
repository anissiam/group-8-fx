package com.example.javafxstudent;

import java.util.ArrayList;

public class Panel {
    static ArrayList<Student> studentArrayList = new ArrayList<>();

    public static void addStudent(Student student){
        studentArrayList.add(student);
    }

    public static Student showStudent(int id){
        Student student = null;
        for (Student student1 :studentArrayList) {
            if (student1.getId()==id){
                student = student1;
                return student;
            }
        }
        return student;
    }

      static void addDefultData(){
        ArrayList<Student> arrayList = new ArrayList<>();
        Student student0 = new Student(0,  "Sami" ,(byte) 20 , "Male",  (byte) 77 , "IT");
        arrayList.add(student0);

        Student student1 = new Student(1,"Ali" ,(byte) 25 , "Male",  (byte) 30 , "CS");
        arrayList.add(student1);
        Student student2 = new Student(2,"Sara" ,(byte) 18 , "Female",  (byte) 20 , "AI");
        arrayList.add(student2);
        Student student3 = new Student(3,"Marwa" ,(byte) 26 , "Female",  (byte) 88 , "IT");
        arrayList.add(student3);

         studentArrayList.addAll(arrayList);
    }

    public static ArrayList<Student> getAllStudent(){
        return studentArrayList;
    }
    public static String deleteStudent(Student student){
        studentArrayList.remove(student);
        return "Done";
    }
}
