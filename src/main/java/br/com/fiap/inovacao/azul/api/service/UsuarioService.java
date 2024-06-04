package br.com.fiap.inovacao.azul.api.service;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;
import br.com.fiap.inovacao.azul.api.domain.endereco.pais.Pais;
import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;
import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;
import br.com.fiap.inovacao.azul.api.domain.endereco.estado.Estado;
import br.com.fiap.inovacao.azul.api.domain.usuario.Usuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.TipoUsuario;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.CriarUsuarioDTO;
import br.com.fiap.inovacao.azul.api.exception.DomainException;
import br.com.fiap.inovacao.azul.api.repository.OngRepository;
import br.com.fiap.inovacao.azul.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OngRepository ongRepository;

    public Usuario createUser(CriarUsuarioDTO dto){
        var user = new Usuario(dto);
        if(dto.idOng() != null && dto.tipoUsuario() == TipoUsuario.COLABORADOR){
            ValidarColaborador(dto.idOng(), dto.tipoUsuario());
            var ong = ongRepository.getReferenceById(dto.idOng());
            user.setOngId(ong);
            ong.getUsuarioId().add(user);
        } else {
            throw new DomainException("A ONG informada nao existe, se existe, por favor coloque o tipo usuario como COLABORADOR");
        }
        var endereco = new Endereco(dto);
        var logradouro = new Logradouro(dto);
        var bairro = new Bairro(dto);
        var cidade = new Cidade(dto);
        var estado = new Estado(dto);
        var pais = new Pais(dto);

        endereco.setUsuarioId(user);
        user.setEnderecoId(endereco);

        endereco.setLogradouroId(logradouro);
        logradouro.getEnderecoId().add(endereco);

        logradouro.setBairroId(bairro);
        bairro.getLogradouroId().add(logradouro);

        bairro.setCidadeId(cidade);
        cidade.getBairroId().add(bairro);

        cidade.setEstadoId(estado);
        estado.getCidadeId().add(cidade);

        estado.setPaisId(pais);
        pais.getEstadoId().add(estado);

        usuarioRepository.save(user);
        return user;
    }

    private void ValidarColaborador(Long id, TipoUsuario tipoUsuario){
        if(tipoUsuario != TipoUsuario.COLABORADOR){
            throw new DomainException("Apenas passe o dado de identificação da ong se você for um colaborador");
        }
        if(!ongRepository.existsById(id)){
            throw new DomainException("ONG referenciada não existe");
        }
    }
}
