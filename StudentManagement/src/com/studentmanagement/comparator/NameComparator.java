package com.studentmanagement.comparator;

import java.util.Comparator;

import com.studentmanagement.Student;

public class NameComparator implements Comparator<Student> {

    private boolean ascending;

    public NameComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Student o1, Student o2) {

        if(ascending) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o2.getName().compareTo(o1.getName());
        }

    }

}
