package br.com.fiap.inovacao.azul.api.controller;

import br.com.fiap.inovacao.azul.api.domain.helper.HelperReport;
import br.com.fiap.inovacao.azul.api.domain.report.dto.CriarReportDTO;
import br.com.fiap.inovacao.azul.api.domain.report.dto.DetalhesReportDTO;
import br.com.fiap.inovacao.azul.api.domain.report.dto.DetalhesReportUsuarioDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.AtualizarUsuarioDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.CriarUsuarioDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.DetalhesUsuarioDTO;
import br.com.fiap.inovacao.azul.api.domain.usuario.dto.ListagemUsuarioDTO;
import br.com.fiap.inovacao.azul.api.repository.ReportRepository;
import br.com.fiap.inovacao.azul.api.repository.UsuarioRepository;
import br.com.fiap.inovacao.azul.api.service.ReportService;
import br.com.fiap.inovacao.azul.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> criar(@RequestBody @Valid CriarUsuarioDTO dto, UriComponentsBuilder builder){
        var user = usuarioService.createUser(dto);
        var uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesUsuarioDTO(user));
    }

    @PostMapping("/reports/{idHelper}")
    @Transactional
    public ResponseEntity<DetalhesReportDTO> criarReport(@RequestBody @Valid CriarReportDTO dto, @PathVariable("idHelper") Long id, UriComponentsBuilder builder){
        var report = reportService.criarReport(dto, id);
        var uri = builder.path("/{id}").buildAndExpand(report.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesReportDTO(report));
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Page<DetalhesReportUsuarioDTO>> listarReports(@PathVariable Long id, Pageable pageable){
        var report = reportRepository.buscarReportsPorHelper(id, pageable).map(DetalhesReportUsuarioDTO::new);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesUsuarioDTO> detalhes(@PathVariable Long id){
        var user = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesUsuarioDTO(user));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemUsuarioDTO>> listar(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable){
        var listaUsuarios = usuarioRepository.findAll(pageable).map(ListagemUsuarioDTO::new);
        return ResponseEntity.ok(listaUsuarios);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesUsuarioDTO> atualizar(@RequestBody @Valid AtualizarUsuarioDTO dto, @PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesUsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
