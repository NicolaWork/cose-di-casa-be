package app.casa.controller;

import app.casa.dto.ApiResponse;
import app.casa.dto.ProdottoDto;
import app.casa.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    ProdottoService prodottoService;

    @PostMapping("/crea")
    public ResponseEntity<ApiResponse<ProdottoDto>> creaProdotto (@AuthenticationPrincipal UserDetails utente, @RequestBody ProdottoDto prodottoDto){
            String mailUtente = utente.getUsername();
            ProdottoDto prodottoResponse = prodottoService.createProdotto(prodottoDto, mailUtente);
            return ResponseEntity.ok(ApiResponse.ok("Prodotto creato con successo", prodottoResponse));

    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<ProdottoDto>>> getAllProdotti (@AuthenticationPrincipal UserDetails utente){
        String mailUtente = utente.getUsername();
        List<ProdottoDto> prodottoList = prodottoService.getAllProdotti(mailUtente);
        return ResponseEntity.ok(ApiResponse.ok("Risorsa recuperata con successo", prodottoList));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteProdotto (@AuthenticationPrincipal UserDetails utente, @PathVariable("id") Long id){
        String mailUtente = utente.getUsername();
        Boolean esito = prodottoService.deleteProdotto(mailUtente, id);
        return ResponseEntity.ok(ApiResponse.ok("Prodotto eliminato",esito));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProdottoDto>> updateProdotto (@AuthenticationPrincipal UserDetails utente, @PathVariable("id")Long id, @RequestBody ProdottoDto prodottoDto){
        String mailUtente = utente.getUsername();
        ProdottoDto prodotto = prodottoService.updateProdotto(mailUtente, id, prodottoDto);
        return ResponseEntity.ok(ApiResponse.ok("Prodotto aggiornato", prodotto));
    }
}
