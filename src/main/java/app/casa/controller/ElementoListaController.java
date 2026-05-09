package app.casa.controller;

import app.casa.dto.ApiResponse;
import app.casa.dto.ElementoListaDto;
import app.casa.entity.ElementoLista;
import app.casa.mapper.ElementoMapper;
import app.casa.service.ElementoListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elemento-lista")
public class ElementoListaController {

    @Autowired
    ElementoListaService elementoListaService;

    @PostMapping("/crea")
    public ResponseEntity<ApiResponse<ElementoListaDto>> creaElemento(@AuthenticationPrincipal UserDetails user, @RequestBody ElementoListaDto elementoListaDto){
        String email = user.getUsername();
        ElementoLista elementoLista = elementoListaService.creaElemento(email, elementoListaDto);
        ElementoListaDto response = ElementoMapper.toDto(elementoLista);
        return ResponseEntity.ok(ApiResponse.ok("Elemento creato con successo", response));
    }
/*
    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<List<ElementoListaDto>>> getAll(@AuthenticationPrincipal UserDetails user){
        String email = user.getUsername();
        List<ElementoListaDto> response = elementoListaService.getAll(email);
        return ResponseEntity.ok(ApiResponse.ok("Risorsa recuperata con successo", response));
    }

 */
}

