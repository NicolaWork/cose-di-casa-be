package app.casa.service;

import app.casa.dto.LoginDto;
import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;
import app.casa.mapper.UtenteMapper;
import app.casa.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    private  final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UtenteRepository utenteRepository;

    public Utente registrazioneNuovoUtente(UtenteDto utenteDto) {
        String passwordCriptata = passwordEncoder.encode(utenteDto.getPassword());
        utenteDto.setPassword(passwordCriptata);
        Utente utente = UtenteMapper.toEntity(utenteDto);
        return utenteRepository.save(utente);
    }

    public Boolean autenticazione(LoginDto loginDto) {
        Optional<Utente> utente = utenteRepository.findByEmail(loginDto.getEmail());
        return utente.filter(value -> passwordEncoder.matches(loginDto.getPassword(), value.getPassword())).isPresent();
    }

    public Utente getUtente(String mailUtente) {
        return utenteRepository.findByEmail(mailUtente).get();
    }
}
