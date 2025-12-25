package com.studentmanagement.model;

import java.time.LocalDate;

public class MockDetail {
String moduleName;
	MockStatus mockStatus;
	LocalDate mockdate;
	
	public MockDetail(String moduleName, MockStatus mockStatus, LocalDate mockdate) {
		super();
		this.moduleName = moduleName;
		this.mockStatus = mockStatus;
		this.mockdate = mockdate;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public MockStatus getMockStatus() {
		return mockStatus;
	}
	public void setResult(MockStatus mockStatus) {
		this.mockStatus = mockStatus;
	}
	public LocalDate getMockdate() {
		return mockdate;
	}
	public void setMockdate(LocalDate mockdate) {
		this.mockdate = mockdate;
	}
	@Override
	public String toString() {
		return "MockDetail [moduleName=" + moduleName + ", mockStatus=" + mockStatus + ", mockdate=" + mockdate + "]";
	}


}
