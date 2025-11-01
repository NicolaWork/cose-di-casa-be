package app.casa.controller;

import app.casa.dto.ApiResponse;
import app.casa.dto.LoginDto;
import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;
import app.casa.service.UtenteService;
import app.casa.security.JwtToken;
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
    public ResponseEntity<ApiResponse<Map<String,String>>> registrazioneNuovoUtente (@RequestBody UtenteDto utenteDto){
        Utente utente = utenteService.registrazioneNuovoUtente(utenteDto);
        return ResponseEntity.ok(ApiResponse.ok("Utente "+utente.getNome()+" "+utente.getCognome()+" salvato!",null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Map<String, String>>> login (@RequestBody LoginDto loginDto){
        Boolean autenticato = utenteService.autenticazione(loginDto);

        if(autenticato){
            String token = jwtToken.generaToken(loginDto.getEmail());
            Map<String, String> payload = Map.of("token", token);
            return ResponseEntity.ok(ApiResponse.ok("Login effettuato con successo", payload));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("Ritenta sarai più fortunato", "Credennziali non valide."));
        }
    }
}
