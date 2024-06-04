package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroContribuicaoRepository extends JpaRepository<RegistroContribuicao, Long> {
}
