package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.ong.Ong;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.AtualizarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.CriarOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.DetalhesOngDTO;
import br.com.fiap.inovacao.azul.api.domain.ong.dto.ListagemOngDTO;
import br.com.fiap.inovacao.azul.api.repository.OngColaboradorRepository;
import br.com.fiap.inovacao.azul.api.repository.OngRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    private OngRepository ongRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ListagemOngDTO> criar(@RequestBody @Valid CriarOngDTO dto, UriComponentsBuilder builder){
        var ong = new Ong(dto);
        var uri = builder.path("/{id}").buildAndExpand(ong.getId()).toUri();
        ongRepository.save(ong);
        return ResponseEntity.created(uri).body(new ListagemOngDTO(ong));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesOngDTO> detalhesOng(@PathVariable Long id){
        var ongs = ongRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesOngDTO(ongs));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemOngDTO>> listar(Pageable pageable){
        var lista = ongRepository.findAll(pageable).map(ListagemOngDTO::new);
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesOngDTO> atualizar(@RequestBody @Valid AtualizarOngDTO dto, @PathVariable Long id){
        var ong = ongRepository.getReferenceById(id);
        ong.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesOngDTO(ong));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesOngDTO> excluir(@PathVariable Long id){
        return ResponseEntity.notFound().build();
    }
}
