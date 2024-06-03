package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
