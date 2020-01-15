package co.ecommerce.core.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.ecommerce.core.entity.Categoria;


/**
 * Interface that provides basic operations of a crud for the
 * category entity
 * @author Alexander Leal
 *
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	public Optional<Categoria> findByCodigo(String codigo);
}
	