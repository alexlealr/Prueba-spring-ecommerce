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
 * Controller that is responsible for making requests to the back for category management
 * @author Alexander Leal
 *
 */
@Controller
public class CategoriaController {
	
	/**
	 * Instance of the class where the rest service methods are
	 */
	@Autowired
	private MetodosRest<GenericDTO> dto;
	
	/**
	 * Instance of the class where the rest service methods are
	 */
	@Autowired
    private MetodosRest<Categoria> crearRest;
	
	/**
	 * Method that is responsible for listing the categorys and making requests to the back-end
	 * @param model provides attributes for the view
	 * @return categoria/consultar-categoria html template
	 */
	@GetMapping("/consultar-categoria")
	public String categoria(Model model) {
		
		 GenericDTO res = dto.get("/listar-categoria",GenericDTO.class);
		 System.out.println("alexx");
		 model.addAttribute("categoriaList", res.getLstObjectsDTO());
		return "categoria/consultar-categoria";
	}
	
	/**
	 * Method that is responsible for creating categorys and making requests to the back-end
	 * @param pro category object
	 * @param model provides attributes for the view
	 * @param foto
	 * @return
	 */
	
	@PostMapping("/crear-categoria")
	public String crearCategoria(Categoria pro, ModelMap model, @RequestParam("file") MultipartFile foto) {
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			  String rootPath = directorioRecursos.toFile().getAbsolutePath();
			  try {
				  byte[] bytes = foto.getBytes();
				  Path rutaCompleta = Paths.get(rootPath+ "//"+ foto.getOriginalFilename());
				  Files.write(rutaCompleta, bytes);
				  pro.setFoto(foto.getOriginalFilename());
				  } catch (IOException e) {
					  e.printStackTrace();
			  }
		  }
		
		
		model.addAttribute("categoria", new Categoria());
		System.out.println(pro.getCodigo());
		crearRest.post(pro, Categoria.class, "/registrar-categoria");
		return "redirect:/consultar-categoria";
		
	}
	
	/**
	 * Method that can make the request to the back-end to edit categories
	 * @param pro category object
	 * @param model provides attributes for the view
	 * @return redirect:/consultar-categoria
	 */
	@PostMapping("/editar-categoria")
	public String postEditCategoria(Categoria pro, ModelMap model) {
		model.addAttribute("categoria", new Categoria());
		crearRest.put(pro, Categoria.class, "/editar-categoria");
		return "redirect:/consultar-categoria";

	}

}
