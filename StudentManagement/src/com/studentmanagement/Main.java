package com.studentmanagement;

// import com.studentmanagement.consoleview.StudentView;
import com.studentmanagement.desktopview.StudentFrameView;
// import com.studentmanagement.model.Student;

public class Main {
public static void main(String[] args) {
	// StudentView studentView = new StudentView();

	// studentView.showMenu();

	StudentFrameView studentFrameView = new StudentFrameView();
	studentFrameView.setVisible(true);
}

}
