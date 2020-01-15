package co.ecommerce.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.ecommerce.core.entity.Categoria;
import co.ecommerce.core.entity.GenericoDTO;
import co.ecommerce.core.entity.Producto;
import co.ecommerce.core.service.CategoriaService;

/**
 *controller of the categories that is responsible for receiving the requests made by 
 *the front-end and returning a response
 * @author Alexander Leal
 *
 */
@RestController
public class CategoriaController {

	
	@Autowired
	CategoriaService categoriaService;

	/**
	 * Method that is responsible for consulting the categories and return them to the front-end
	 * @return respuesta category list
	 */
	@GetMapping("/listar-categoria")
	public GenericoDTO listarCategoria() {
		GenericoDTO respuesta = new GenericoDTO();
		List<Categoria> entidad = (List<Categoria>) categoriaService.getAllUsers();
		respuesta.setLstObjectsDTO(new ArrayList<>(entidad));
		return respuesta;
	}
    
	/**
	 * Method that is responsible for creating categories
	 * @param pro object category
	 * @return respuesta returns the created category
	 * @throws Exception 
	 */
	@PostMapping("/registrar-categoria")
	public Categoria crearCategoria(@RequestBody Categoria pro) throws Exception {
		Categoria respuesta = new Categoria();
		respuesta = categoriaService.createCategoria(pro);
		return respuesta;
	}
	
	/**
	 * Method that is responsible for editing a specific category
	 * @param pro object category
	 * @return respuesta edited category
	 * @throws Exception
	 */
	@PutMapping("/editar-categoria")
	public Categoria postEditarCategoria(@RequestBody Categoria pro) throws Exception {
		Categoria respuesta = new Categoria();
		respuesta = categoriaService.updateCategoria(pro);				
		return respuesta;

	}
}
