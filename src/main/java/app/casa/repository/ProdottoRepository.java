package app.casa.repository;

import app.casa.dto.ProdottoDto;
import app.casa.entity.Prodotto;
import app.casa.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {


    List<Prodotto> findAllByUtente(Utente Utente);

}
