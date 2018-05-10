package edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.upc.dao.IEmployeeDAO;
import edu.upc.entity.Employee;
import edu.upc.service.IEmployeeSERVICE;


@Named
@RequestScoped

public class EmployeeSERVICEImpl implements IEmployeeSERVICE, Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@EJB
	private IEmployeeDAO eDao;

	@Override
	public void insertar(Employee t) {
		try {
			eDao.insertar(t);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void actualizar(Employee t) {
		try {
			eDao.actualizar(t);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void eliminar(int idT) {
		try {
			eDao.eliminar(idT);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public List<Employee> listar() throws Exception {
		return eDao.listar();
	}

	@Override
	public Employee listarId(int idT) throws Exception {
		return eDao.listarId(idT);
	}

	@Override
	public List<Employee> buscarNombre(Employee employee) throws Exception {
		return eDao.buscarNombre(employee);
	}
}
