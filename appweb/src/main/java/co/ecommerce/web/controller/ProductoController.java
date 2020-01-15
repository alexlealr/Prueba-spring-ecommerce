package co.ecommerce.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.ecommerce.web.entity.Categoria;
import co.ecommerce.web.entity.GenericDTO;
import co.ecommerce.web.entity.Producto;
import co.ecommerce.web.util.MetodosRest;

/**
 * Controller that is responsible for making requests to the back for product management
 * @author Alexander Leal
 *
 */
@Controller
public class ProductoController {


	/**
	 * Instance of the class where the rest service methods are
	 */
	@Autowired
	private MetodosRest<GenericDTO> dto;
	
	@Autowired
	private MetodosRest<GenericDTO> dto2;
	
	/**
	 * Instance of the class where the rest service methods are
	 */
	@Autowired
	private MetodosRest<Producto> crearRest;
	
	@Autowired
    private MetodosRest<Categoria> crearRest2;
	
	/**
	 * Method that is responsible for listing the products and making requests to the back-end
	 * @param model provides attributes for the view
	 * @return producto/consultar-producto html template
	 */
	@GetMapping("/consultar-producto")
	public String producto(Model model) {

		GenericDTO res = dto.get("/listar-producto", GenericDTO.class);
		GenericDTO res2 = dto2.get("/listar-categoria", GenericDTO.class);
		model.addAttribute("productoList", res.getLstObjectsDTO());

		model.addAttribute("categorias", res2.getLstObjectsDTO());
		return "producto/consultar-producto";
	}

	/**
	 * Method that is responsible for creating products and making requests to the back-end
	 * @param pro product object
	 * @param model provides attributes for the view
	 * @param foto
	 * @return redirect:/consultar-producto
	 */
	@PostMapping("/crear-producto")
	public String crearProducto(Producto pro, ModelMap model, @RequestParam("file") MultipartFile foto) {
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				pro.setImagen(foto.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		model.addAttribute("producto", new Producto());
		System.out.println(pro.getCodigo());
		crearRest.post(pro, Producto.class, "/registrar-producto");
		return "redirect:/consultar-producto";

	}
    
	/**
	 * Method that can make the request to the back-end to edit products
	 * @param pro product object
	 * @param model provides attributes for the view
	 * @return redirect:/consultar-producto
	 */
	@PostMapping("/editar-producto")
	public String postEditProducto(Producto pro, ModelMap model) {

		model.addAttribute("producto", new Producto());
		crearRest.put(pro, Producto.class, "/editar-producto");

		return "redirect:/consultar-producto";

	}
}
