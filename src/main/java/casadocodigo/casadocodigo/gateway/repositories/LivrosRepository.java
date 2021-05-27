package casadocodigo.casadocodigo.gateway.repositories;


import casadocodigo.casadocodigo.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrosRepository extends JpaRepository<Livro, String> {

    List<Livro> findByTitulo(String titulo);
}
