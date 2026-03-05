package com;

public class StudentCourseDetails {

	private String name;
	private String qualification;
	private String stream;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String gettechnicalStream() {

		String s = null;
		if (stream.equals("java")) {

			s = "This is Object Oriented Programming ";
		} else if (stream.equals("python")) {

			s = "Scripting language !!! ";
		}
		return s;

	}

}
