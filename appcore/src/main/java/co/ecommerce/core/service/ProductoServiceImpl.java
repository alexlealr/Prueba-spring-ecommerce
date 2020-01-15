package co.ecommerce.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ecommerce.core.entity.Producto;
import co.ecommerce.core.repository.ProductoRepository;

/**
 * Class that implements product crude methods
 * @author Alexander Leal
 *
 */
@Service
public class ProductoServiceImpl implements ProductoService{

	/**
	 * Product Repository
	 */
	@Autowired
	ProductoRepository repository;
	
	/**
	 * It allows you to cycle through all the data stored in product
     */
	@Override
	public Iterable<Producto> getAllUsers() {
		return repository.findAll();
	}
	 /**
     * Check if the product code exists
     * @param asig product object
     * @return
     * @throws Exception
     */
	private boolean checkCodigoExist(Producto asig) throws Exception {
		Optional<Producto> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	/**
	 * Create a product
	 * @param asig product object
	 * @return
	 * @throws Exception
	 */
	@Override
	public Producto createProducto(Producto asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}
 
	/**
	 * It allows to obtain a product by the id
	 * @param id product id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Producto getProductoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El producto para editar no existe."));
	}
	
	/**
	 * Update a product
	 * @param asig product object
	 * @return
	 * @throws Exception
	 */
	@Override
	public Producto updateProducto(Producto fromUser) throws Exception {
		Producto toAsignatura = getProductoById(fromUser.getId());
		mapProducto(fromUser, toAsignatura);
		return repository.save(toAsignatura);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapProducto(Producto from,Producto to) {
		to.setCodigo(from.getCodigo());
		to.setNombre(from.getNombre());
		to.setDescripcion(from.getDescripcion());
		to.setPeso(from.getPeso());
		to.setPrecio(from.getPrecio());
		
	}
	
	/**
	 * Delete a product by its id
	 * @param id product id
	 * @throws Exception
	 */
	@Override
	public void deleteProducto(Long id) throws Exception {
		Producto asig = repository.findById(id).orElseThrow(() -> new Exception("Categoria no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}
	
	
}
