package edu.upc.service;

import java.util.List;

public interface ISERVICE<T>{
	
	public void insertar(T t);
	public void actualizar(T t);
	public void eliminar(int idT);
	public List<T> listar() throws Exception;
	public T listarId(int idT) throws Exception;

}
