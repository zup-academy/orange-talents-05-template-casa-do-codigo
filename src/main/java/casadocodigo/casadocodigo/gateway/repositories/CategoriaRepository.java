package casadocodigo.casadocodigo.gateway.repositories;


import casadocodigo.casadocodigo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
