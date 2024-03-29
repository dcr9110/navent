package modelarPedidos;

public class BumexMemcached {
	
	private static BumexMemcached bumexMemcached = null;
	
	private BumexMemcached() {
		super();
	}
	
	/*
	 * Singleton
	 */
	public static BumexMemcached getInstance(){
		//Inicia el singleton o devuelve de estar creado
		if( bumexMemcached == null ){
			bumexMemcached = new BumexMemcached();
		}
		return bumexMemcached;
	}
	
	public void set(String key, Object value){
		
	}
	
	public Object get(String key){
		return null;
	}
	
	public void delete(String key){
		
	}

	public static BumexMemcached getBumexMemcached() {
		return bumexMemcached;
	}

	public static void setBumexMemcached(BumexMemcached bumexMemcached) {
		BumexMemcached.bumexMemcached = bumexMemcached;
	}
	
}
