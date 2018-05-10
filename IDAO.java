package edu.upc.dao;

import java.util.List;

public interface IDAO<T> {

	
	public void insertar(T t);
	public void actualizar(T t);
	public void eliminar(int idT);
	public List<T> listar();
	public T listarId(int idT);

}
