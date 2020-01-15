package co.ecommerce.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.ecommerce.core.entity.GenericoDTO;
import co.ecommerce.core.entity.Producto;
import co.ecommerce.core.service.ProductoService;

/**
 * Controller of the products that is responsible for receiving the requests made by 
 * the front-end and returning a response
 * @author Alexander Leal
 *
 */
@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;

	/**
	 * method that is responsible for consulting the products and return them to the front-end
	 * @return respuesta product list
	 */
	@GetMapping("/listar-producto")
	public GenericoDTO listarProducto() {
		GenericoDTO respuesta = new GenericoDTO();
		List<Producto> entidad = (List<Producto>) productoService.getAllUsers();
		respuesta.setLstObjectsDTO(new ArrayList<>(entidad));
		return respuesta;
	}

	/**
	 * Method that is responsible for creating products
	 * @param pro object product
	 * @return respuesta returns the created product
	 * @throws Exception
	 */
	@PostMapping("/registrar-producto")
	public Producto crearProducto(@RequestBody Producto pro) throws Exception {
		Producto respuesta = new Producto();
		respuesta = productoService.createProducto(pro);
		return respuesta;
	}
	
	/**
	 * Method that is responsible for editing a specific product
	 * @param pro object product
	 * @return respuesta edited product
	 * @throws Exception
	 */
	@PutMapping("/editar-producto")
	public Producto postEditarProducto(@RequestBody Producto pro) throws Exception {
		Producto respuesta = new Producto();
		respuesta = productoService.updateProducto(pro);				
		return respuesta;

	}
}
