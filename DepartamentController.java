package edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.upc.entity.Departament;
import edu.upc.service.IDepartamentSERVICE;

@Named
@SessionScoped
public class DepartamentController implements Serializable {

	@Inject
	private IDepartamentSERVICE departamentService;
	
	private Departament departament;
	private List<Departament> listaDepartamentos;
	
	@PostConstruct
	public void init() {
		this.listaDepartamentos = new ArrayList<>();
		this.departament = new Departament();
		this.listar();
		}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<Departament> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departament> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	
    public String nuevoDepartamento() {
		this.setDepartament(new Departament());
		return "departament.xhtml";
	}

	public void insertarActualizar() {
		try {
			if (departament.getIdDepartament() > 0) {
				departamentService.actualizar(departament);
				limpiarDepartamento();
			} else {
				departamentService.insertar(departament);
				limpiarDepartamento();
			}
			this.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void eliminar(Departament departament) {
		try {
			departamentService.eliminar(departament.getIdDepartament());
			listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listar() {
		try {
			listaDepartamentos = departamentService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listarId(Departament dept) {
		try {
			departament = departamentService.listarId(dept.getIdDepartament());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void buscarDepartamentoNombre() {
		try {
			if (departament.getNameDepartament().isEmpty()) {
				this.listar();
			} else {
			listaDepartamentos =this.departamentService.buscarNombre(this.getDepartament());
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarDepartamento() {
		this.init();
	}

	
}
