package app.casa.service;

import app.casa.dto.ProdottoDto;
import app.casa.entity.Prodotto;
import app.casa.entity.Utente;
import app.casa.mapper.ProdottoMapper;
import app.casa.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {

    @Autowired
    ProdottoRepository prodottoRepository;

    @Autowired
    UtenteService utenteService;

    public ProdottoDto createProdotto(ProdottoDto prodottoDto, String mailUtente) {
        Utente utente = utenteService.getUtente(mailUtente);
        Prodotto prodotto = prodottoRepository.save(ProdottoMapper.toEntity(prodottoDto,utente));
        return ProdottoMapper.toDto(prodotto);
    }

    public List<ProdottoDto> getAllProdotti(String mailUtente) {
        Utente utente = utenteService.getUtente(mailUtente);
        return prodottoRepository.findAllByUtente(utente).stream().map(ProdottoMapper::toDto).toList();
    }

    public Boolean deleteProdotto(String mailUtente, Long id) {
        Utente utente = utenteService.getUtente(mailUtente);
        try{
            prodottoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ProdottoDto updateProdotto(String mailUtente, Long id, ProdottoDto prodottoDto) {
        Utente utente = utenteService.getUtente(mailUtente);
        Optional<Prodotto> prodotto = prodottoRepository.findById(id);
        if(prodotto.isPresent()){
            prodotto.get().setNome(prodottoDto.getNome());
            prodotto.get().setCategoria(prodottoDto.getCategoria());
            prodottoRepository.save(prodotto.get());
        }
        return ProdottoMapper.toDto(prodotto.get());
    }
}
