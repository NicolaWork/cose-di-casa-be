package app.casa.mapper;

import app.casa.dto.ElementoListaDto;
import app.casa.entity.ElementoLista;
import app.casa.entity.Utente;

public class ElementoMapper {


    public static ElementoLista toEntity(Utente utente, ElementoListaDto elementoListaDto) {
        ElementoLista elementoLista = new ElementoLista();
        elementoLista.setIdElemento(elementoListaDto.getIdElemento());
        elementoLista.setQuantita(elementoListaDto.getQuantita());
        elementoLista.setListaSpesa(null);
        return elementoLista;
    }

    public static ElementoListaDto toDto(ElementoLista elementoLista) {
        return new ElementoListaDto(
                elementoLista.getIdElemento(),
                elementoLista.getQuantita(),
                elementoLista.isAcquistato(),
                null,
                elementoLista.getProdotto().getIdProdotto()
        );
    }
}
