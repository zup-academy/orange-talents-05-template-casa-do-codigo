package casadocodigo.casadocodigo.gateway.repositories;

import casadocodigo.casadocodigo.entities.Categoria;
import casadocodigo.casadocodigo.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro, String> {
}
