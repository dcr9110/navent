/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelarPedidos;

/**
 *
 * @author Usuario
 */
public class ModelarPedidos implements Modelo<Pedido>{
    BumexMemcached bumexMemcached;
    PedidoDAO pedidoDAO;
    
    /*
        Recibe un Pedido
        Luego actualiza la BBDD
    */
    @Override
    public void crearPedidos(Pedido pedido){
        //Crea o modifica el pedido dentro de la BBDD
        pedidoDAO.insertOrUpdate(pedido);
    }
    
    /*
        Recibe el Id del Pedido y el Objeto Pedido
        Modifica el Pedido
    */
    @Override
    public void modificarPedidos(Integer key, Pedido pedido){
        Pedido pedidoAux = (Pedido) bumexMemcached.get(key.toString());
        //Revisa si el Pedido se encuentra en cache o en la BBDD
        if(pedidoAux == null){
            //En caso de estar en la BBDD 
            this.crearPedidos(pedido);
       }else{
            //En caso de estar en la cache actualiza el Bumex
            bumexMemcached.set(key.toString(), pedido);
        }
    }
    
    /*
        Reccibe el Id del Pedido
        Retorna el Pedido
    */
    @Override
    public Pedido buscarPedidos(Integer key){
        Pedido pedido = (Pedido) bumexMemcached.get(key.toString());
        //Revisa si el Pedido esta en cache
        if(pedido == null){
            //En caso de no estar en cache busca en la BBDD
            pedido = (Pedido) pedidoDAO.select(key);
       }else{
            //Al no encontrar lo en la BBDD
            System.out.println("Pedido no encontrado");
        }
        return pedido;
    }
    
    
    /*
        Recibe el Id del Pedido
        Luego borra el Pedido
    */
    @Override
    public void borrarPedidos(Integer key){
        Pedido pedido = (Pedido) bumexMemcached.get(key.toString());
        //Verifica que si el Pedido se encuentra en Cache
        if(pedido != null){
            bumexMemcached.delete(key.toString());
        }
        
        pedido = (Pedido) pedidoDAO.select(key);
        if(pedido != null){
            pedidoDAO.delete(pedido);
        }
    }
  
}
