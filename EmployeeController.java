package edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.upc.entity.Departament;
import edu.upc.entity.Employee;
import edu.upc.service.IDepartamentSERVICE;
import edu.upc.service.IEmployeeSERVICE;

@Named
@SessionScoped
public class EmployeeController implements Serializable{
	
	@Inject
	private IDepartamentSERVICE departamentService;
	@Inject
	private IEmployeeSERVICE employeeService;

	
	private Departament departament;;
	private List<Departament> listaDepartamentos;

	private Employee employee;
	private List<Employee> listaEmpleados;

	
	   @PostConstruct
		public void init() {
			departament = new Departament();
			employee = new Employee();
			listaDepartamentos = new ArrayList<>();
			listaEmpleados = new ArrayList<>();

			this.listarEmpleado();
			this.listarDepartamento();
		}

	      public String nuevoEmpleado() {
	  		this.setEmployee(new Employee());
	  		return "employee.xhtml";
	  	}

	  	public void insertarActualizar() {
	  		try {
	  			if (employee.getIdEmployee() > 0) {
	  				employeeService.actualizar(employee);
	  				limpiarEmpleado();
	  			} else {
	  				employeeService.insertar(employee);
	  				limpiarEmpleado();
	  			}
	  			this.listarEmpleado();
	  		} catch (Exception e) {
	  			e.getMessage();
	  		}
	  	}

	  	public void eliminar(Employee employee) {
	  		try {
	  			employeeService.eliminar(employee.getIdEmployee());
	  			listarEmpleado();
	  		} catch (Exception e) {
	  			e.getMessage();
	  		}
	  	}

	  	public void listarEmpleado() {
	  		try {
	  			listaEmpleados = employeeService.listar();
	  		} catch (Exception e) {
	  			e.getMessage();
	  		}
	  	}

	  	public void listarDepartamento() {
	  		try {
	  			listaDepartamentos = departamentService.listar();
	  		} catch (Exception e) {
	  			e.getMessage();
	  		}
	  	}

	  	public void mostrar(Employee empl) {
	  		try {
	  			this.departament.setIdDepartament(empl.getDepartament().getIdDepartament());
	  			this.departament.setNameDepartament(empl.getDepartament().getNameDepartament());
	  			this.departament.setDescriptionDepartament(empl.getDepartament().getDescriptionDepartament());

	  			this.employee.setIdEmployee(empl.getIdEmployee());
	  			this.employee.setNameEmployee(empl.getNameEmployee());
	  			this.employee.setAdressEmployee(empl.getAdressEmployee());
	  			this.employee.setDepartament(departament);

	  		} catch (Exception e) {
	  			e.getStackTrace();
	  		}
	  	}

	  	public void buscarEmployeeNombre() {
	  		try {
	  			if (employee.getNameEmployee().isEmpty()) {
	  				this.listarEmpleado();
	  			} else {
	  				listaEmpleados = this.employeeService.buscarNombre(this.getEmployee());
	  			}
	  		} catch (Exception e) {
	  			e.getMessage();
	  		}
	  	}

	  	public void limpiarEmpleado() {
	  		this.init();
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

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public List<Employee> getListaEmpleados() {
			return listaEmpleados;
		}

		public void setListaEmpleados(List<Employee> listaEmpleados) {
			this.listaEmpleados = listaEmpleados;
		}

}
