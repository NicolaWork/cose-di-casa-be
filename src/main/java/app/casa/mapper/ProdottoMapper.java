package app.casa.mapper;

import app.casa.dto.ProdottoDto;
import app.casa.entity.Prodotto;
import app.casa.entity.Utente;

public class ProdottoMapper {

    public static Prodotto toEntity(ProdottoDto prodottoDto, Utente utente) {
        Prodotto prodotto = new Prodotto();
        prodotto.setIdProdotto(prodottoDto.getIdProdotto());
        prodotto.setNome(prodottoDto.getNome());
        prodotto.setCategoria(prodottoDto.getCategoria());
        prodotto.setUtente(utente);
        return prodotto;
    }

    public static ProdottoDto toDto(Prodotto prodotto) {
        return new ProdottoDto(
                prodotto.getIdProdotto(),
                prodotto.getNome(),
                prodotto.getCategoria()
        );
    }
}
