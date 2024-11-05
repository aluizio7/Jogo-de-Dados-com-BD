package br.ufrn.eaj.dados.domain.enums;

public enum ResultadoJogo {
    JOGADOR_GANHOU("Jogador ganhou!"), MAQUINA_VENCEU("Máquina venceu!");

    private final String descricao;

    private ResultadoJogo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
