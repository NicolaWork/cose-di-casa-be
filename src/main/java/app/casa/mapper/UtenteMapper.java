package app.casa.mapper;

import app.casa.dto.UtenteDto;
import app.casa.entity.Utente;

public class UtenteMapper {

    public static Utente toEntity(UtenteDto utenteDto){
        Utente utente = new Utente();
        utente.setNome(utenteDto.getNome());
        utente.setCognome(utenteDto.getCognome());
        utente.setEmail(utenteDto.getEmail());
        utente.setPassword(utenteDto.getPassword());
        return utente;
    }
}
