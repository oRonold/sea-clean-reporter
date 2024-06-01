package br.com.fiap.inovacao.azul.api.domain.address.city;

import br.com.fiap.inovacao.azul.api.domain.address.district.District;
import br.com.fiap.inovacao.azul.api.domain.address.state.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_CIDADE")
@SequenceGenerator(name = "seq_gs_cidade", sequenceName = "seq_gs_inov_cidade", allocationSize = 1)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_cidade")
    @Column(name = "cd_cidade")
    private Long id;

    @Column(name = "nm_cidade", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "cityId")
    private List<District> districtId;

    @ManyToOne
    @JoinColumn(name = "cd_estado", nullable = false)
    private State stateId;
}
