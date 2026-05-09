package app.casa.service;

import app.casa.dto.ElementoListaDto;
import app.casa.entity.ElementoLista;
import app.casa.entity.Prodotto;
import app.casa.entity.Utente;
import app.casa.mapper.ElementoMapper;
import app.casa.repository.ElementoListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementoListaService {

    @Autowired
    UtenteService utenteService;

    @Autowired
    ElementoListaRepository elementoListaRepository;

    @Autowired
    ProdottoService prodottoService;


    public ElementoLista creaElemento(String email, ElementoListaDto elementoListaDto) {
        Utente utente = utenteService.getUtente(email);
        Prodotto prodotto = prodottoService.prodottoRepository.getReferenceById(elementoListaDto.getIdProdotto());
        ElementoLista elementoLista = elementoListaRepository.save(ElementoMapper.toEntity(utente, elementoListaDto));
        elementoLista.setProdotto(prodotto);
        return elementoListaRepository.saveAndFlush(elementoLista);
    }
/*
    public List<ElementoListaDto> getAll(String email) {
        Utente utente = utenteService.getUtente(email);
        return elementoListaRepository.findAllByUtente(utente).stream().map(ElementoMapper::toDto).toList();
    }

 */
}
