package com.studentmanagement.model;

import java.util.ArrayList;

public interface StudentDao {

    public ArrayList<Student> getStudentDetails();

    public void addStudent(Student s);

    public Student searchByFrn(String frn);

    public Student searchByEmail(String email);

    public Student searchByMobile(long mobileNo);

    public ArrayList<Student> searchByName(String name);

    public ArrayList<Student> searchByDob(String dob);

    public boolean deleteStudent(String frn);

    public void saveStudents(ArrayList<Student> students);

    public void updateStudent(Student students);

    public ArrayList<MockDetail> getMockDetailsByFRN(String frn);

    public ArrayList<Student> sortByFrn(boolean ascending);

    public ArrayList<Student> sortByName(boolean ascending);

    public ArrayList<Student> getBirthdayStudents() ;

}
