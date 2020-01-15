package co.ecommerce.core.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import co.ecommerce.core.entity.Usuario;

/**
 * Interface that provides basic operations of a crud for the
 * usuario entity
 * @author Alexander leal
 *
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	public Optional<Usuario> findByCodigo(String codigo);
	public Optional<Usuario> findByUsername(String correo);


}
