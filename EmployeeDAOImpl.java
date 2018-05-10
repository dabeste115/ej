package edu.upc.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.upc.dao.IEmployeeDAO;
import edu.upc.entity.Employee;

@Stateless
public class EmployeeDAOImpl  implements IEmployeeDAO, Serializable{

	
	@PersistenceContext(unitName = "semana6PU")
	private EntityManager manager;
	
	@Override
	public void insertar(Employee t) {
		try {
			manager.persist(t);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void actualizar(Employee t) {
		try {
			manager.merge(t);
		} catch (Exception e) {
			e.getMessage();

		}
		
	}

	@Override
	public void eliminar(int idT) {
		try {
			Employee empl = new Employee();
			empl = manager.getReference(Employee.class, idT);
			manager.remove(empl);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listar() {
		List<Employee> lista = null;
		try {
			Query query = manager.createQuery("FROM Employee e");
			lista = (List<Employee>) query.getResultList();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;

	}
	@SuppressWarnings("unchecked")
	@Override
	public Employee listarId(int idT) {
		List<Employee> lista = null;
		Employee em = new Employee();
		try {
			Query query = manager.createQuery("FROM Employee e where e.idEmployee=?1");
			query.setParameter(1, idT);
			lista = (List<Employee>) query.getResultList();
			if (lista != null && !lista.isEmpty()) {
				em = lista.get(0);
			}
		} catch (Exception e) {
			e.getMessage();

		}
		return em;

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> buscarNombre(Employee employee) {
		List<Employee> lista = null;
		try {
			Query query = manager.createQuery("FROM Employee e where e.nameEmployee like ?1");
			query.setParameter(1, "%" + employee.getNameEmployee() + "%");
			lista=(List<Employee>) query.getResultList();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;

	}

}
