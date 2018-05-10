package edu.upc.dao;

import java.util.List;

import javax.ejb.Local;

import edu.upc.entity.Employee;


@Local

public interface IEmployeeDAO  extends IDAO<Employee>{

	
	
	public List<Employee> buscarNombre(Employee employee);
	}


