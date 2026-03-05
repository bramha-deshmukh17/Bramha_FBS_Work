package com.bean;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Device_pojo")
public class DevicesPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;

	@Column(name = "dName", nullable = false, length = 50)
	private String dName;

	@Column(name = "dModule", nullable = false, length = 30)
	private String dModule;

	@Column(name = "dVal", nullable = false)
	private double dVal;

	public DevicesPojo() {
		// TODO Auto-generated constructor stub
	}

	public DevicesPojo(String dName, String dModule, double dVal) {
		super();
		this.dName = dName;
		this.dModule = dModule;
		this.dVal = dVal;
	}

	// ✅ Capital D — getDId() not getdId()
	public int getDId() {
		return dId;
	}

	public void setDId(int dId) {
		this.dId = dId;
	}

	// ✅ Capital D — getDName() not getdName()
	public String getDName() {
		return dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

	// ✅ Capital D — getDModule() not getdModule()
	public String getDModule() {
		return dModule;
	}

	public void setDModule(String dModule) {
		this.dModule = dModule;
	}

	// ✅ Capital D — getDVal() not getdVal()
	public double getDVal() {
		return dVal;
	}

	public void setDVal(double dVal) {
		this.dVal = dVal;
	}

	@Override
	public String toString() {
		return "DevicesPojo [dId=" + dId + ", dName=" + dName + ", dModule=" + dModule + ", dVal=" + dVal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dId, dModule, dName, dVal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DevicesPojo other = (DevicesPojo) obj;
		return dId == other.dId && Objects.equals(dModule, other.dModule) && Objects.equals(dName, other.dName)
				&& Double.doubleToLongBits(dVal) == Double.doubleToLongBits(other.dVal);
	}

}
