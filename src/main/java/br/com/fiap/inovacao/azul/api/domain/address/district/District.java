package br.com.fiap.inovacao.azul.api.domain.address.district;

import br.com.fiap.inovacao.azul.api.domain.address.city.City;
import br.com.fiap.inovacao.azul.api.domain.address.publicArea.PublicArea;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_BAIRRO")
@SequenceGenerator(name = "seq_gs_bairro", sequenceName = "seq_gs_inov_bairro", allocationSize = 1)
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_bairro")
    @Column(name = "cd_bairro")
    private Long id;

    @Column(name = "nm_bairro", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "districtId")
    private List<PublicArea> publicAreaId;

    @ManyToOne
    @JoinColumn(name = "cd_cidade", nullable = false)
    private City cityId;
}
