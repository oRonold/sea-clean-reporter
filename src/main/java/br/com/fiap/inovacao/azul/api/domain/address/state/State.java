package br.com.fiap.inovacao.azul.api.domain.address.state;

import jakarta.persistence.*;

@Entity
@Table(name = "GS_INOV_ESTADO")
@SequenceGenerator(name = "seq_gs_inov_estado", sequenceName = "seq_gs_estado", initialValue = 1, allocationSize = 1)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_estado")
    @Column(name = "cd_estado")
    private Long id;

    @Column(name = "nm_estado", nullable = false, length = 100)
    private String name;

    @Column(name = "nr_ddd", nullable = false, length = 2)
    private String ddd;
}
