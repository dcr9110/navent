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
public interface Modelo<T> {
    
    /**
	 * 
         * Recive un objeto de tipo Pedido
	 * Luego lo carga en la cache
         * 
	 * @param object
	 */
    public void crearPedidos(T object);
    
    /**
	 * 
	 * Recibe el id del Pedido a modificar
         * Tambien recibe el Pedido moficado
         * Luego lo carga en la cache
         * 
	 * @param key
         * @param object
	 */
    public void modificarPedidos(Integer key, T object);
    
    /**
	 * 
	 * Recibe el Id del Pedido
         * Luego devuelve el Pedido
         * 
	 * @param key
         * @return 
	 */
    public T buscarPedidos(Integer key);
    
    /**
	 * 
	 * Recibe el Id del Pedido
         * Luego borra el pedido de la cache y de la BBDD
         * 
	 * @param key
	 */
    public void borrarPedidos(Integer key);
}
