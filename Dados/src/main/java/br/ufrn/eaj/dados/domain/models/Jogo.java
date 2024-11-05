package br.ufrn.eaj.dados.domain.models;

import br.ufrn.eaj.dados.domain.enums.ResultadoJogo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("jogadores")
    private List<Jogador> jogadores;

    private int valorDados;

    @JsonProperty("quantidadeJogadores")
    private int quantidadeJogadores;

    private ResultadoJogo resultado;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public int getValorDados() {
        return valorDados;
    }

    public void setValorDados(int valorDados) {
        this.valorDados = valorDados;
    }

    public int getQuantidadeJogadores() {
        return quantidadeJogadores;
    }

    public void setQuantidadeJogadores(int quantidadeJogadores) {
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public ResultadoJogo getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoJogo resultado) {
        this.resultado = resultado;
    }
}
