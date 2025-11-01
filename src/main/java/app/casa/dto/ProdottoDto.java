package app.casa.dto;

public class ProdottoDto {

    private Long idProdotto;
    private String nome;
    private String categoria;

    public ProdottoDto(){}

    public ProdottoDto(Long idProdotto, String nome, String categoria){
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
