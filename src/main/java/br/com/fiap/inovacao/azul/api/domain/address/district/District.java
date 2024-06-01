package br.com.fiap.inovacao.azul.api.domain.address.district;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_BAIRRO")
@SequenceGenerator(name = "seq_gs_inov_bairro", sequenceName = "seq_gs_bairro", initialValue = 1, allocationSize = 1)
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_inov")
    @Column(name = "cd_bairro")
    private Long id;

    @Column(name = "nm_bairro", nullable = false, length = 100)
    private String name;
}
