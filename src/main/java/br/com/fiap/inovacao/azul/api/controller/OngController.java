package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.ong.Ong;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.CriarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.DetalhesOngDTO;
import br.com.fiap.inovacao.azul.api.repository.OngRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngRepository ongRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesOngDTO> create(@RequestBody @Valid CriarOngDTO dto, UriComponentsBuilder builder){
        var ong = new Ong(dto);
        var uri = builder.path("/{id}").buildAndExpand(ong.getId()).toUri();
        ongRepository.save(ong);
        return ResponseEntity.created(uri).body(new DetalhesOngDTO(ong));
    }
}
