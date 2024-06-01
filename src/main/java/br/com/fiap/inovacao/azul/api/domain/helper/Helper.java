package br.com.fiap.inovacao.azul.api.domain.helper;

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
@Table(name = "GS_INOV_HELPER")
@SequenceGenerator(name = "seq_gs_helper", sequenceName = "seq_gs_inov_helper", allocationSize = 1)
public class Helper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_helper")
    @Column(name = "cd_helper")
    private Long id;

    @Column(name = "nm_helper", nullable = false, length = 100)
    private String name;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String phone;

    @OneToOne
    @JoinColumn(name = "cd_usuario", nullable = false)
    private User userId;

    @OneToMany(mappedBy = "helperId")
    private List<HelperReport> helperReportId;

}
