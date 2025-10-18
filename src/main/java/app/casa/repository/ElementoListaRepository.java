package app.casa.repository;

import app.casa.entity.ElementoLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoListaRepository extends JpaRepository<ElementoLista, Long> {


}
