package co.ecommerce.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ecommerce.core.entity.Categoria;
import co.ecommerce.core.repository.CategoriaRepository;


/**
 * Class that implements category crude methods
 * @author Alexander Leal
 *
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

	/**
	 * Category Repository
	 */
	@Autowired
	CategoriaRepository repository;
	
	/**
	 * It allows you to cycle through all the data stored in category
     */
	@Override
	public Iterable<Categoria> getAllUsers() {
		return repository.findAll();
	}
    /**
     * Check if the category code exists
     * @param asig category object
     * @return
     * @throws Exception
     */
	private boolean checkCodigoExist(Categoria asig) throws Exception {
		Optional<Categoria> asignaturaFound = repository.findByCodigo(asig.getCodigo());
		if (asignaturaFound.isPresent()) {
			throw new Exception("Codigo no disponible");
		}
		return true;	
	}
	/**
	 * Create a category
	 * @param asig category object
	 * @return
	 * @throws Exception
	 */
	
	@Override
	public Categoria createCategoria(Categoria asig) throws Exception {
		if (checkCodigoExist(asig)) {
			asig = repository.save(asig);
		}
		return asig;
	}
 
	/**
	 * It allows to obtain a category by the id
	 * @param id category id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Categoria getCategoriaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("La categoria para editar no existe."));
	}
	
	/**
	 * Update a category
	 * @param asig category object
	 * @return
	 * @throws Exception
	 */
	
	@Override
	public Categoria updateCategoria(Categoria fromUser) throws Exception {
		Categoria toAsignatura = getCategoriaById(fromUser.getId());
		mapAsignatura(fromUser, toAsignatura);
		return repository.save(toAsignatura);
	}
	
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapAsignatura(Categoria from,Categoria to) {
		to.setCodigo(from.getCodigo());
		to.setNombre(from.getNombre());
		to.setCategoria_padre(from.getCategoria_padre());
		to.setFoto(from.getFoto());
	}
	
	/**
	 * Delete a category by its id
	 * @param category id
	 * @throws Exception
	 */
	@Override
	public void deleteCategoria(Long id) throws Exception {
		Categoria asig = repository.findById(id).orElseThrow(() -> new Exception("Categoria no encontrada -"+this.getClass().getName()));

		repository.delete(asig);
		
	}
	
	

}
