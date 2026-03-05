package com.aug.demo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "mobile_application")

public class Application {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;

//	@Column(name = "aName", nullable = false, length = 20)
	private String aName;

//	@Column(name = "aFrontTech", nullable = false, length = 20)
	private String FrontTech;

//	@Column(name = "aBackTech", nullable = false, length = 20)
	private String BackTech;

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public Application(int aId, String aName, String frontTech, String backTech) {
		super();
		this.aId = aId;
		this.aName = aName;
		FrontTech = frontTech;
		BackTech = backTech;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getFrontTech() {
		return FrontTech;
	}

	public void setFrontTech(String frontTech) {
		FrontTech = frontTech;
	}

	public String getBackTech() {
		return BackTech;
	}

	public void setBackTech(String backTech) {
		BackTech = backTech;
	}

	@Override
	public int hashCode() {
		return Objects.hash(BackTech, FrontTech, aId, aName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		return Objects.equals(BackTech, other.BackTech) && Objects.equals(FrontTech, other.FrontTech)
				&& aId == other.aId && Objects.equals(aName, other.aName);
	}

	@Override
	public String toString() {
		return "Application [aId=" + aId + ", aName=" + aName + ", FrontTech=" + FrontTech + ", BackTech=" + BackTech
				+ "]";
	}

}
