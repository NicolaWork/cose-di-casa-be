package app.casa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lista_spesa")
public class ListaSpesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Long idLista;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToMany(mappedBy = "listaSpesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElementoLista> elementi = new ArrayList<>();

    public ListaSpesa() {
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<ElementoLista> getElementi() {
        return elementi;
    }

    public void setElementi(List<ElementoLista> elementi) {
        this.elementi = elementi;
    }
}
