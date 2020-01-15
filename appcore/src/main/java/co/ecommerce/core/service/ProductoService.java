package co.ecommerce.core.service;

import co.ecommerce.core.entity.Producto;

/**
 * Layer of services that provides necessary operations for the product entity
 * 
 * @author Alexander Leal
 *
 */
public interface ProductoService {

	/**
	 * It allows you to cycle through all the data stored in product
	 * @return
	 */
	public Iterable<Producto> getAllUsers();

	/**
	 * Create a product	
	 * @param asig product object
	 * @return
	 * @throws Exception
	 */

	public Producto createProducto(Producto asig) throws Exception;

	/**
	 * It allows to obtain a product by the id
	 * @param id product id
	 * @return
	 * @throws Exception
	 */
	public Producto getProductoById(Long id) throws Exception;

	/**
	 * Update a product
	 * @param asig product object
	 * @return
	 * @throws Exception
	 */
	public Producto updateProducto(Producto asig) throws Exception;

	/**
	 * Delete a product by the id
	 * @param id product id
	 * @throws Exception
	 */
	public void deleteProducto(Long id) throws Exception;
}
