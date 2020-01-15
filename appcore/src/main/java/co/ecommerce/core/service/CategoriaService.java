package co.ecommerce.core.service;

import co.ecommerce.core.entity.Categoria;

/**
 * Layer of services that provides necessary operations for the category entity
 * @author Alexander Leal
 *
 */
public interface CategoriaService {

	/**
	 * It allows you to cycle through all the data stored in category
	 * @return
	 */
	public Iterable<Categoria> getAllUsers();
	
	/**
	 * Create a category 	
	 * @param asig category object
	 * @return
	 * @throws Exception
	 */

	public Categoria createCategoria(Categoria asig) throws Exception;

	/**
	 * It allows to obtain a category by the id
	 * @param id category id
	 * @return
	 * @throws Exception
	 */
	public Categoria getCategoriaById(Long id) throws Exception;

	/**
	 * Update a category
	 * @param asig category object
	 * @return
	 * @throws Exception
	 */
	public Categoria updateCategoria(Categoria asig) throws Exception;

	/**
	 * Delete a category by the id
	 * @param id category id
	 * @throws Exception
	 */
	public void deleteCategoria(Long id) throws Exception;
}
