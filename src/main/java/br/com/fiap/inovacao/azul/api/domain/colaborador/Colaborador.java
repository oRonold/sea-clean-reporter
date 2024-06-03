package br.com.fiap.inovacao.azul.api.domain.colaborador;

import br.com.fiap.inovacao.azul.api.domain.contribuicao.RegistroContribuicao;
import br.com.fiap.inovacao.azul.api.domain.ong.OngCollaborator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_COLABORADOR")
@SequenceGenerator(name = "seq_gs_colaborador", sequenceName = "seq_gs_inov_colaborador", allocationSize = 1)
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_colaborador")
    @Column(name = "cd_colaborador")
    private Long id;

    @Column(name = "nm_colaborador", nullable = false, length = 100)
    private String name;

    @Column(name = "st_colaborador", nullable = false, length = 8)
    @Enumerated(EnumType.STRING)
    private StatusColaborador status;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String phone;

    @OneToMany(mappedBy = "colabId")
    private List<OngCollaborator> ongColaboradorId;

    @OneToMany(mappedBy = "colabId")
    private List<RegistroContribuicao> contributionsId;

    @OneToMany(mappedBy = "colaboradorId")
    private List<ColaboradorReport> colaboradorReportId;

}
