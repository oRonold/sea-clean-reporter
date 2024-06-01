package br.com.fiap.inovacao.azul.api.domain.contributions;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_REGISTRO_CONTRIBUICAO")
@SequenceGenerator(name = "seq_gs_inov_contribuicao", sequenceName = "seq_gs_contribuicao", initialValue = 1, allocationSize = 1)
public class ContributionsRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_contribuicao")
    @Column(name = "cd_contribuicao")
    private Long id;

    @Column(name = "ds_contribuicao", nullable = false, length = 100)
    private String description;

    @Column(name = "dt_contribuicao", nullable = false)
    private LocalDate date;

}
