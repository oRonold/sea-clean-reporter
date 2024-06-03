package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
