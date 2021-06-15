package casadocodigo.casadocodigo.gateway.controller;

import casadocodigo.casadocodigo.dtos.DetalhesLivroSiteDTO;
import casadocodigo.casadocodigo.entities.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DetalheSiteController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable("id") long id) {

        Livro buscaLivro = manager.find(Livro.class, id);

        if (buscaLivro == null){

            return ResponseEntity.notFound().build();

        }


        DetalhesLivroSiteDTO detalhesLivroSiteDTO = new DetalhesLivroSiteDTO(buscaLivro);
        return ResponseEntity.ok(detalhesLivroSiteDTO);
    }
}
