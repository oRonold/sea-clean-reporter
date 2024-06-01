package br.com.fiap.inovacao.azul.api.domain.collaborator;

import br.com.fiap.inovacao.azul.api.domain.report.Report;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_COLABORADOR_REPORT")
@SequenceGenerator(name = "seq_gs_colaborador_report", sequenceName = "seq_gs_inov_colaborador_report", allocationSize = 1)
public class CollaboratorReport {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_colaborador_report")
    @Column(name = "cd_colaborador_report")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cd_colaborador", nullable = false)
    private Collaborator collaboratorId;

    @ManyToOne
    @JoinColumn(name = "cd_report", nullable = false)
    private Report reportId;
}
