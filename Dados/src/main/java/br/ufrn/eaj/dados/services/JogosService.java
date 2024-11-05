package br.ufrn.eaj.dados.services;

import br.ufrn.eaj.dados.domain.enums.ResultadoJogo;
import br.ufrn.eaj.dados.domain.models.Dado;
import br.ufrn.eaj.dados.domain.models.Jogador;
import br.ufrn.eaj.dados.domain.models.Jogo;
import br.ufrn.eaj.dados.repositories.JogosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosService {
    @Autowired
    private JogosRepository jogosRepository;

    public List<Jogo> findAll() {
        return (List<Jogo>) jogosRepository.findAll();
    }

    public Jogo findById(Long jogoId) {
        return jogosRepository.findById(jogoId).get();
    }

    public void jogar(Jogo jogo) {
        if (jogo.getQuantidadeJogadores() < 2) {
            throw new RuntimeException("É necessário pelo menos 2 jogadores para jogar");
        }

        if (jogo.getQuantidadeJogadores() > 6) {
            throw new RuntimeException("O número máximo de jogadores é 6");
        }

        if (jogo.getValorDados() < 2 || jogo.getValorDados() > 12) {
            throw new RuntimeException("O valor dos dados deve estar entre 2 e 12");
        }

        for (Jogador jogador : jogo.getJogadores()) {
            if (jogador.getAposta() == jogo.getValorDados()) {
                jogador.setVencedor(true);
                jogo.setResultado(ResultadoJogo.JOGADOR_GANHOU);
            } else {
                jogo.setResultado(ResultadoJogo.MAQUINA_VENCEU);
            }
        }

        jogosRepository.save(jogo);
    }
}
