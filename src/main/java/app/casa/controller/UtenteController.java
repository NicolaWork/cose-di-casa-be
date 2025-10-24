package app.casa.controller;

import app.casa.dto.LoginDto;
import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;
import app.casa.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @PostMapping("/registrazione")
    public String registrazioneNuovoUtente (@RequestBody UtenteDto utenteDto){
        Utente utente = utenteService.registrazioneNuovoUtente(utenteDto);
        return "Utente "+utente.getNome()+" "+utente.getCognome()+" salvato!";
    }

    @PostMapping("/login")
    public Boolean login (@RequestBody LoginDto loginDto){
        Boolean response = utenteService.autenticazione(loginDto);
        return response;
    }
}
