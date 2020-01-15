package co.ecommerce.core.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ecommerce.core.entity.Producto;


/**
 * Interface that provides basic operations of a crud for the
 * product entity
 * @author Alexander leal
 *
 */
	@Repository
	public interface ProductoRepository extends CrudRepository<Producto, Long> {
		public Optional<Producto> findByCodigo(String codigo);
	}

