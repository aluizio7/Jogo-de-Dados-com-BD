package br.ufrn.eaj.dados.domain.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jogador {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private int aposta;

    private boolean vencedor = false;

    @ManyToOne
    private Jogo jogo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAposta() {
        return aposta;
    }

    public void setAposta(int aposta) {
        this.aposta = aposta;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }
}
