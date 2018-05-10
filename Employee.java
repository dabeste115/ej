package edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = " Employee")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmployee;

	@Column(name = "nameEmployee", length = 60, nullable = false)
	private String nameEmployee;

	@Column(name = "adressEmployee", length = 60, nullable = true)
	private String adressEmployee;

	@ManyToOne
	@JoinColumn(name = "idDepartment", nullable = false)
	private Departament departament;

	public Employee() {
		super();
	}

	public Employee(int idEmployee, String nameEmployee, String adressEmployee, Departament departament) {
		super();
		this.idEmployee = idEmployee;
		this.nameEmployee = nameEmployee;
		this.adressEmployee = adressEmployee;
		this.departament = departament;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getAdressEmployee() {
		return adressEmployee;
	}

	public void setAdressEmployee(String adressEmployee) {
		this.adressEmployee = adressEmployee;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}




}