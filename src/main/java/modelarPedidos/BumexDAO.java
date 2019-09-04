/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelarPedidos;

/**
 *
 * @author Usuario
 * @param <T>
 */
public interface BumexDAO<T> {
	
	/**
	 * 
	 * Inserta un nuevo objeto en la base de datos o modifica un objeto existente 
	 * (en cado de crear uno nuevo, el pedido pasado como parámetro se completa con el nuevo id).
	 * 
	 * @param object
	 */
	public void insertOrUpdate(T object);
	
	/**
	 * Elimina el objeto que corresponde al id recibido.
	 * 
	 * @param object
	 */
	public void delete(T object);
	
	/**
	 * Busca un objeto por id.
	 * 
	 * @param id
	 * @return
	 */
	public T select(Integer id);
	
}
