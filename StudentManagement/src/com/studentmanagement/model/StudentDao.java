package com.studentmanagement.model;

import java.util.ArrayList;

public interface StudentDao {

    public ArrayList<Student> getStudentDetails();

    public void addStudent(Student s);

    public ArrayList<Student> search(String field, String value);

    public boolean deleteStudent(String frn);

    public void saveStudents(ArrayList<Student> students);

    public void updateStudent(Student students);

    public ArrayList<MockDetail> getMockDetailsByFRN(String frn);

    public void saveMockDetails(String frn, ArrayList<MockDetail> mockDetails);

    public ArrayList<Student> sort(String field, boolean ascending);

    public ArrayList<Student> getBirthdayStudents();

}
