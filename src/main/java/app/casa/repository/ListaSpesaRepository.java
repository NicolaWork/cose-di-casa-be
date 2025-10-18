package app.casa.repository;

import app.casa.entity.ListaSpesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaSpesaRepository extends JpaRepository<ListaSpesa, Long> {


}
