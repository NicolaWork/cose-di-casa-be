package app.casa.service;

import app.casa.dto.LoginDto;
import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;
import app.casa.mapper.UtenteMapper;
import app.casa.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    UtenteRepository utenteRepository;

    public Utente registrazioneNuovoUtente(UtenteDto utenteDto) {
        Utente utente = UtenteMapper.toEntity(utenteDto);
        return utenteRepository.save(utente);
    }

    public Boolean autenticazione(LoginDto loginDto) {
        Optional<Utente> utente = utenteRepository.findByEmail(loginDto.getEmail());
        if(utente.isPresent() && Objects.equals(utente.get().getPassword(),loginDto.getPassword()))
            return true;
        return false;
    }
}
