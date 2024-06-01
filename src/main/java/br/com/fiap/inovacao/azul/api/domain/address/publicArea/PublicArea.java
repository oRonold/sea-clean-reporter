package br.com.fiap.inovacao.azul.api.domain.address.publicArea;

import br.com.fiap.inovacao.azul.api.domain.address.Address;
import br.com.fiap.inovacao.azul.api.domain.address.district.District;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_LOGRADOURO")
@SequenceGenerator(name = "seq_gs_logradouro", sequenceName = "seq_gs_inov_logradouro", allocationSize = 1)
public class PublicArea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_logradouro")
    @Column(name = "cd_logradouro")
    private Long id;

    @Column(name = "ds_logradouro", nullable = false, length = 100)
    private String publicPlace;

    @Column(name = "nr_cep", nullable = false, length = 9)
    private String zipCode;

    @OneToMany(mappedBy = "publicAreaId")
    private List<Address> addressId;

    @ManyToOne
    @JoinColumn(name = "cd_bairro", nullable = false)
    private District districtId;
}
