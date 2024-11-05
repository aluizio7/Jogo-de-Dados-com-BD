package br.ufrn.eaj.dados.repositories;

import br.ufrn.eaj.dados.domain.models.Jogo;
import org.springframework.data.repository.CrudRepository;

public interface JogosRepository extends CrudRepository<Jogo, Long> {
}
