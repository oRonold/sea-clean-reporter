package br.com.fiap.inovacao.azul.api.domain.address.state;

import br.com.fiap.inovacao.azul.api.domain.address.city.City;
import br.com.fiap.inovacao.azul.api.domain.address.country.Country;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GS_INOV_ESTADO")
@SequenceGenerator(name = "seq_gs_estado", sequenceName = "seq_gs_inov_estado", allocationSize = 1)
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_estado")
    @Column(name = "cd_estado")
    private Long id;

    @Column(name = "nm_estado", nullable = false, length = 100)
    private String name;

    @Column(name = "nr_ddd", nullable = false, length = 2)
    private String ddd;

    @OneToMany(mappedBy = "stateId")
    private List<City> cityId;

    @ManyToOne
    @JoinColumn(name = "cd_pais", nullable = false)
    private Country countryId;
}
