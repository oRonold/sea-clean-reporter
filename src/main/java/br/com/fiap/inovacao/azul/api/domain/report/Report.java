package br.com.fiap.inovacao.azul.api.domain.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_REPORT")
@SequenceGenerator(name = "seq_gs_inov_report", sequenceName = "seq_gs_report", initialValue = 1, allocationSize = 1)
@EntityListeners(AuditingEntityListener.class)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_report")
    @Column(name = "cd_report")
    private Long id;

    @Column(name = "ds_report", nullable = false, length = 100)
    private String description;

    @Column(name = "dt_report", nullable = false)
    @CreatedDate
    private LocalDateTime timestamp;

    @Column(name = "st_report", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private StatusReport status;
}
