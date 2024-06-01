package br.com.fiap.inovacao.azul.api.domain.user;

import br.com.fiap.inovacao.azul.api.domain.address.Address;
import br.com.fiap.inovacao.azul.api.domain.helper.Helper;
import br.com.fiap.inovacao.azul.api.domain.ong.Ong;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "GS_INOV_USUARIO")
@SequenceGenerator(name = "seq_gs_usuario", sequenceName = "seq_gs_inov_usuario", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gs_usuario")
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

    @OneToOne(mappedBy = "userId")
    private Helper helperId;

    @ManyToOne
    @JoinColumn(name = "cd_ong")
    private Ong ongId;

    @OneToOne
    @JoinColumn(name = "cd_endereco", nullable = false)
    private Address addressId;

}
