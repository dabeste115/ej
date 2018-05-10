package edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.upc.dao.IDepartamentDAO;
import edu.upc.entity.Departament;
import edu.upc.service.IDepartamentSERVICE;

@Named
@RequestScoped
public class DepartamentSERVICEImpl implements IDepartamentSERVICE, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private IDepartamentDAO dDao;

	@Override
	public void insertar(Departament t) {
		try {
			dDao.insertar(t);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void actualizar(Departament t) {
		try {
			dDao.actualizar(t);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void eliminar(int idT) {
		try {
			dDao.eliminar(idT);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public List<Departament> listar() throws Exception {
		return dDao.listar();

	}

	@Override
	public Departament listarId(int idT) throws Exception {
		return dDao.listarId(idT);
	}

	@Override
	public List<Departament> buscarNombre(Departament departament) throws Exception {
		return dDao.buscarNombre(departament);
	}
}
