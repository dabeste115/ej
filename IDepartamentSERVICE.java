package edu.upc.service;

import java.util.List;

import edu.upc.entity.Departament;

public interface IDepartamentSERVICE extends ISERVICE<Departament>  {

	
	public List<Departament> buscarNombre(Departament departament) throws Exception;
}
