package br.com.fiap.inovacao.azul.api.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_USER")
@SequenceGenerator(name = "seq_gs_inov_user", sequenceName = "seq_gs_user", initialValue = 1, allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_user")
    @Column(name = "cd_usuario")
    private Long id;

    @Column(name = "nm_usuario", nullable = false, length = 100)
    private String name;

    @Column(name = "ds_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "ds_senha", nullable = false, length = 10)
    private String password;

    @Column(name = "tp_usuario", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
