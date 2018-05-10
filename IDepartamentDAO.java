package edu.upc.dao;

import java.util.List;

import javax.ejb.Local;

import edu.upc.entity.Departament;

@Local
public interface IDepartamentDAO extends IDAO<Departament> {

	
	public List<Departament> buscarNombre(Departament departament);
	}


