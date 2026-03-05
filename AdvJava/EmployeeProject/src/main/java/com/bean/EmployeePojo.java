package com.bean;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Employee_pojo")
public class EmployeePojo {

	@Id
//	here identity generates the id autoincrement mode
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;

	@Column(name = "eName", nullable = false, length = 50)
	private String eName;

	@Column(name = "eSal", nullable = false)
	private double eSal;

	@Column(unique = true)
	private String email;

	@Transient
	private double bonus;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "eId")
	private List<DevicesPojo> dev;

	public EmployeePojo() {

	}

	public EmployeePojo(String eName, double eSal, String email, double bonus, List<DevicesPojo> dev) {
		super();
		this.eName = eName;
		this.eSal = eSal;
		this.email = email;
		this.bonus = bonus;
		this.dev = dev;
	}

	public List<DevicesPojo> getDev() {
		return dev;
	}

	public void setDev(List<DevicesPojo> dev) {
		this.dev = dev;
	}

	public int getEId() {
		return eId;
	}

	public void setEId(int eId) {
		this.eId = eId;
	}

	public String getEName() {
		return eName;
	}

	public void setEName(String eName) {
		this.eName = eName;
	}

	public double getESal() {
		return eSal;
	}

	public void setESal(double eSal) {
		this.eSal = eSal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "EmployeePojo [eId=" + eId + ", eName=" + eName + ", eSal=" + eSal + ", email=" + email + ", bonus="
				+ bonus + ", dev=" + dev + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonus, dev, eId, eName, eSal, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePojo other = (EmployeePojo) obj;
		return Double.doubleToLongBits(bonus) == Double.doubleToLongBits(other.bonus) && Objects.equals(dev, other.dev)
				&& eId == other.eId && Objects.equals(eName, other.eName)
				&& Double.doubleToLongBits(eSal) == Double.doubleToLongBits(other.eSal)
				&& Objects.equals(email, other.email);
	}

}
