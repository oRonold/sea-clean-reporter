package br.com.fiap.inovacao.azul.api.domain.report;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.colaborador.ColaboradorReport;
import br.com.fiap.inovacao.azul.api.domain.helper.HelperReport;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_REPORT")
@SequenceGenerator(name = "seq_gs_report", sequenceName = "seq_gs_inov_report", allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_report")
    @Column(name = "cd_report")
    private Long id;

    @Column(name = "ds_report", nullable = false, length = 100)
    private String descricao;

    @Column(name = "dt_report", nullable = false)
    @CreatedDate
    private LocalDateTime dataRegistro;

    @Column(name = "st_report", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private StatusReport status;

    @OneToMany(mappedBy = "reportId")
    private List<HelperReport> reportHelperId;

    @OneToMany(mappedBy = "reportId")
    private List<ColaboradorReport> colaboradorReportId;

    @ManyToOne
    @JoinColumn(name = "cd_endereco", nullable = false)
    private Endereco enderecoId;
}
