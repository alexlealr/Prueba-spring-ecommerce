package co.ecommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.ecommerce.web.entity.GenericDTO;
import co.ecommerce.web.util.MetodosRest;

@Controller
public class AutenticacionController {

	@Autowired
	private MetodosRest<GenericDTO> dto;
	
	@GetMapping({ "/", "/home" })
	public String index(Model model) {

		GenericDTO res = dto.get("/listar-producto", GenericDTO.class);
		System.out.println("alexx");
		model.addAttribute("productoList", res.getLstObjectsDTO());
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "index";
	}
}
