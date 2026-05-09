package app.casa.repository;

import app.casa.entity.ElementoLista;
import app.casa.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementoListaRepository extends JpaRepository<ElementoLista, Long> {


//    List<ElementoLista> findAllByUtente(Utente utente);
}
