package app.casa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "elemento_lista")
public class ElementoLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_elemento")
    private Long idElemento;

    @Column(name = "quantita", nullable = false)
    private int quantita = 1;

    @Column(name = "acquistato", nullable = false)
    private boolean acquistato = false;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    private ListaSpesa listaSpesa;

    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;

    public ElementoLista() {
    }

    public Long getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Long idElemento) {
        this.idElemento = idElemento;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public boolean isAcquistato() {
        return acquistato;
    }

    public void setAcquistato(boolean acquistato) {
        this.acquistato = acquistato;
    }

    public ListaSpesa getListaSpesa() {
        return listaSpesa;
    }

    public void setListaSpesa(ListaSpesa listaSpesa) {
        this.listaSpesa = listaSpesa;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }
}
