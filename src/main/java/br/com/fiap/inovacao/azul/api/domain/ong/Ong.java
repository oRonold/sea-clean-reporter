package br.com.fiap.inovacao.azul.api.domain.ong;

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
@Table(name = "GS_INOV_ONG")
@SequenceGenerator(name = "seq_gs_ong", sequenceName = "seq_gs_inov_ong", allocationSize = 1)
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_ong")
    @Column(name = "cd_ong")
    private Long id;

    @Column(name = "nm_ong", nullable = false, length = 100)
    private String name;

    @Column(name = "ds_ong", nullable = false, length = 100)
    private String description;

    @Column(name = "ds_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "nr_telefone", nullable = false, length = 15)
    private String phone;

    @OneToMany(mappedBy = "ongId")
    private List<User> userId;

    @OneToMany(mappedBy = "ongId")
    private List<OngCollaborator> ongCollaboratorId;

}
