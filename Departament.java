package edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departament")

public class Departament implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartament;

	@Column(name = "nameDepartament", length = 45, nullable = false)
	private String nameDepartament;

	@Column(name = "descriptionDepartament", length = 45, nullable = true)
	private String descriptionDepartament;

	public Departament() {
		super();
	}

	public int getIdDepartament() {
		return idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public String getNameDepartament() {
		return nameDepartament;
	}

	public void setNameDepartament(String nameDepartament) {
		this.nameDepartament = nameDepartament;
	}

	public String getDescriptionDepartament() {
		return descriptionDepartament;
	}

	public void setDescriptionDepartament(String descriptionDepartament) {
		this.descriptionDepartament = descriptionDepartament;
	}

	public Departament(int idDepartament, String nameDepartament, String descriptionDepartament) {
		super();
		this.idDepartament = idDepartament;
		this.nameDepartament = nameDepartament;
		this.descriptionDepartament = descriptionDepartament;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descriptionDepartament == null) ? 0 : descriptionDepartament.hashCode());
		result = prime * result + idDepartament;
		result = prime * result + ((nameDepartament == null) ? 0 : nameDepartament.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departament other = (Departament) obj;
		if (descriptionDepartament == null) {
			if (other.descriptionDepartament != null)
				return false;
		} else if (!descriptionDepartament.equals(other.descriptionDepartament))
			return false;
		if (idDepartament != other.idDepartament)
			return false;
		if (nameDepartament == null) {
			if (other.nameDepartament != null)
				return false;
		} else if (!nameDepartament.equals(other.nameDepartament))
			return false;
		return true;
	}
	

}