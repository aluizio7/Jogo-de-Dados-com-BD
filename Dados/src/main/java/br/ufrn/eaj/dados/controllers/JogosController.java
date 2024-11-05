package br.ufrn.eaj.dados.controllers;

import br.ufrn.eaj.dados.domain.models.Jogo;
import br.ufrn.eaj.dados.services.JogosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JogosController {

    @Autowired
    private JogosService jogosService;

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("jogos");
        mav.addObject("jogos", jogosService.findAll());

        return mav;
    }

    @GetMapping("/jogo/{id}")
    public ModelAndView jogo(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("jogo");
        mav.addObject("jogo", jogosService.findById(id));

        return mav;
    }

    @PostMapping("/jogar")
    public ResponseEntity<String> jogar(@RequestBody Jogo jogo) {
        try {
            jogosService.jogar(jogo);

            return ResponseEntity.ok().body("Jogo realizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Não foi possível realizar o jogo.\n");
        }
    }
}
