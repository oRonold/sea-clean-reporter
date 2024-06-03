package br.com.fiap.inovacao.azul.api.domain.report.dto;

import br.com.fiap.inovacao.azul.api.domain.helper.Helper;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import br.com.fiap.inovacao.azul.api.domain.report.StatusReport;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.ListagemUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesReportUsuarioDTO(Long idReport,
                                       String descricao,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                       LocalDateTime dataRegistro,
                                       StatusReport statusReport,
                                       @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                                       LocalDateTime dataFinalizacao) {

    public DetalhesReportUsuarioDTO(Report report){
        this(report.getId(), report.getDescricao(), report.getDataRegistro(), report.getStatus(),
                report.getDataFinalizacao());
    }
}
