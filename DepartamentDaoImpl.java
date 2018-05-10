package edu.upc.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.upc.dao.IDepartamentDAO;
import edu.upc.entity.Departament;

@Stateless
public class DepartamentDaoImpl implements IDepartamentDAO, Serializable {

	@PersistenceContext(unitName = "semana6PU")
	private EntityManager manager;
	
	@Override
	public void insertar(Departament t) {
		try {
			manager.persist(t);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void actualizar(Departament t) {
		try {
			manager.merge(t);
		} catch (Exception e) {
			e.getMessage();
		}	
		
	}

	@Override
	public void eliminar(int idT) {
		try {
			Departament dep = new Departament();
			dep = manager.getReference(Departament.class, idT);
			manager.remove(dep);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@SuppressWarnings("unchecked")

	@Override
	public List<Departament> listar() {
		List<Departament> lista = null;
		try {
			Query query = manager.createQuery("FROM Departament d");
			lista = (List<Departament>) query.getResultList();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;

	}

	@SuppressWarnings("unchecked")

	@Override
	public Departament listarId(int idT) {
		List<Departament> lista = null;
		Departament dept =new Departament();
		try {
	
			Query query = manager.createQuery("FROM Departament d where d.idDepartament = ?1");
			query.setParameter(1, idT);
			lista = (List<Departament>) query.getResultList();
			if(lista!=null&& !lista.isEmpty()) {
				dept=lista.get(0);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return dept;

	}

	@SuppressWarnings("unchecked")

	@Override
	public List<Departament> buscarNombre(Departament departament) {
		List<Departament> lista = null;
		try {
			Query query = manager.createQuery("FROM Departament d where d.nameDepartament like ?1");
			query.setParameter(1, "%" + departament.getNameDepartament() + "%");
			lista = (List<Departament>) query.getResultList();
		} catch (Exception e) {
			e.getMessage();
		}		
		return lista;

	}

}
