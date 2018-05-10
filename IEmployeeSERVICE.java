package edu.upc.service;

import java.util.List;

import edu.upc.entity.Employee;

public interface IEmployeeSERVICE extends ISERVICE<Employee>{
	public List<Employee> buscarNombre(Employee employee) throws Exception;
}
