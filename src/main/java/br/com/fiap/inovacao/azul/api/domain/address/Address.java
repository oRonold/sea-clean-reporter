package br.com.fiap.inovacao.azul.api.domain.address;

import br.com.fiap.inovacao.azul.api.domain.address.publicArea.PublicArea;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import br.com.fiap.inovacao.azul.api.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_ENDERECO")
@SequenceGenerator(name = "seq_gs_endereco", sequenceName = "seq_gs_inov_endereco", allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_endereco")
    @Column(name = "cd_endereco")
    private Long id;

    @Column(name = "nr_logradouro", nullable = false, length = 20)
    private String homeId;

    @OneToOne(mappedBy = "addressId")
    private User userId;

    @OneToMany(mappedBy = "addressId")
    private List<Report> reportId;

    @ManyToOne
    @JoinColumn(name = "cd_logradouro", nullable = false)
    private PublicArea publicAreaId;
}
