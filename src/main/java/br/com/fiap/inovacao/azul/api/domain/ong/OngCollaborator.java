package br.com.fiap.inovacao.azul.api.domain.ong;

import br.com.fiap.inovacao.azul.api.domain.collaborator.Collaborator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_ONG_COLAB")
@SequenceGenerator(name = "seq_gs_ong_colaborador", sequenceName = "seq_gs_inov_ong_colaborador", allocationSize = 1)
public class OngCollaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_ong_colaborador")
    @Column(name = "cd_ong_colaborador")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cd_ong", nullable = false)
    private Ong ongId;

    @ManyToOne
    @JoinColumn(name = "cd_colaborador", nullable = false)
    private Collaborator colabId;
}
