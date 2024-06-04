package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.DetalhesColaboradorDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.DetalhesContribuicoesDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.ListagemColaboradorDTO;
import br.com.fiap.inovacao.azul.api.domain.colaborador.dto.RegistroContribuicaoDTO;
import br.com.fiap.inovacao.azul.api.repository.ColaboradorRepository;
import br.com.fiap.inovacao.azul.api.service.ReportService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<Page<ListagemColaboradorDTO>> listar(Pageable pageable){
        var lista = colaboradorRepository.findAll(pageable).map(ListagemColaboradorDTO::new);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/contribuicoes")
    public ResponseEntity<DetalhesContribuicoesDTO> contribuicoesConcluidas(@PathVariable Long id){
        return null;
    }

    @PutMapping("/{idColab}/report/{idReport}")
    @Transactional
    public ResponseEntity<DetalhesColaboradorDTO> marcarComoConcluida(@RequestBody @Valid RegistroContribuicaoDTO dto, @PathVariable Long idColab, @PathVariable Long idReport){
        reportService.confirmarContribuicao(dto, idColab, idReport);
        var colaborador = colaboradorRepository.getReferenceById(idColab);
        return ResponseEntity.ok(new DetalhesColaboradorDTO(colaborador));
    }
}
