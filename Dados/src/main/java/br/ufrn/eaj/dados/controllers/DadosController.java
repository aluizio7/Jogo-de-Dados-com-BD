package br.ufrn.eaj.dados.controllers;

import br.ufrn.eaj.dados.domain.models.Dado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosController {
    Dado dado = new Dado();

    @GetMapping("/lancar-dado")
    public String lancarDado() {
        dado.jogarDado();

        return String.valueOf(dado.getFace());
    }
}
