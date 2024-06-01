package br.com.fiap.inovacao.azul.api.domain.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_ENDERECO")
@SequenceGenerator(name = "seq_gs_inov_endereco", sequenceName = "seq_gs_endereco", initialValue = 1, allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_endereco")
    @Column(name = "cd_endereco")
    private Long id;

    @Column(name = "nr_logradouro", nullable = false, length = 20)
    private String homeId;
}
