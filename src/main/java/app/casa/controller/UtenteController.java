package app.casa.controller;

import app.casa.dto.LoginDto;
import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;
import app.casa.service.UtenteService;
import app.casa.utils.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @Autowired
    JwtToken jwtToken;

    @PostMapping("/registrazione")
    public String registrazioneNuovoUtente (@RequestBody UtenteDto utenteDto){
        Utente utente = utenteService.registrazioneNuovoUtente(utenteDto);
        return "Utente "+utente.getNome()+" "+utente.getCognome()+" salvato!";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDto loginDto){
        Boolean autenticato = utenteService.autenticazione(loginDto);

        if(autenticato){
            String token = jwtToken.generaToken(loginDto.getEmail());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("messaggio","Ritenta sarai più fortunato"));
        }
    }
}
