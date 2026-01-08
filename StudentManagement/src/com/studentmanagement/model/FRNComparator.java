package com.studentmanagement.model;

import java.util.Comparator;

public class FRNComparator implements Comparator<Student> {

	private boolean ascending;

	public FRNComparator(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int compare(Student o1, Student o2) {

		if (ascending) {
			return o1.getFrn().compareTo(o2.getFrn());
		} else {
			return o2.getFrn().compareTo(o1.getFrn());
		}

	}

}
