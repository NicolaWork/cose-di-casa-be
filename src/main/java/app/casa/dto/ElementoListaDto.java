package app.casa.dto;

public class ElementoListaDto {
    private Long idElemento;
    private Integer quantita;
    private Boolean acquistato;
    private Long idLista;
    private Long idProdotto;

    public ElementoListaDto() {
    }

    public ElementoListaDto(Long idElemento, Integer quantita, Boolean acquistato, Long idLista, Long idProdotto) {
        this.idElemento = idElemento;
        this.quantita = quantita;
        this.acquistato = acquistato;
        this.idLista = idLista;
        this.idProdotto = idProdotto;
    }

    public Long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Boolean getAcquistato() {
        return acquistato;
    }

    public void setAcquistato(Boolean acquistato) {
        this.acquistato = acquistato;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
}
