package br.com.fiap.inovacao.azul.api.domain.colaborador.dto;

import java.time.LocalDate;

public record DetalhesContribuicoesDTO(Long id, String descricao, LocalDate dataContribuicao) {
}
