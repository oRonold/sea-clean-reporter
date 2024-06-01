package br.com.fiap.inovacao.azul.api.domain.address.country;

import br.com.fiap.inovacao.azul.api.domain.address.state.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Stack;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_PAIS")
@SequenceGenerator(name = "seq_gs_pais", sequenceName = "seq_gs_inov_pais", allocationSize = 1)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_pais")
    private Long id;

    @Column(name = "nm_cidade", nullable = false, length = 100)
    private String name;

    @Column(name = "cd_telefone_pais", nullable = false, length = 3)
    private String idd;

    @OneToMany(mappedBy = "countryId")
    private List<State> stateId;
}
