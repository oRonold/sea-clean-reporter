package br.com.fiap.inovacao.azul.api.service;

import br.com.fiap.inovacao.azul.api.domain.endereco.Endereco;
import br.com.fiap.inovacao.azul.api.domain.endereco.bairro.Bairro;
import br.com.fiap.inovacao.azul.api.domain.endereco.cidade.Cidade;
import br.com.fiap.inovacao.azul.api.domain.endereco.estado.Estado;
import br.com.fiap.inovacao.azul.api.domain.endereco.logradouro.Logradouro;
import br.com.fiap.inovacao.azul.api.domain.endereco.pais.Pais;
import br.com.fiap.inovacao.azul.api.domain.helper.HelperReport;
import br.com.fiap.inovacao.azul.api.domain.report.Report;
import br.com.fiap.inovacao.azul.api.domain.report.dto.CriarReportDTO;
import br.com.fiap.inovacao.azul.api.exception.DomainException;
import br.com.fiap.inovacao.azul.api.repository.HelperReportRepository;
import br.com.fiap.inovacao.azul.api.repository.HelperRepository;
import br.com.fiap.inovacao.azul.api.repository.ReportRepository;
import br.com.fiap.inovacao.azul.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private HelperRepository helperRepository;

    @Autowired
    private HelperReportRepository helperReportRepository;

    public Report criarReport(CriarReportDTO dto, Long id){
        if(!helperRepository.existsById(id)){
            throw new DomainException("O helper informado não existe");
        }
        var helper = helperRepository.getReferenceById(id);
        var report = new Report(dto);
        var helperReport = new HelperReport();

        var endereco = new Endereco(dto);
        var logradouro = new Logradouro(dto);
        var bairro = new Bairro(dto);
        var cidade = new Cidade(dto);
        var estado = new Estado(dto);
        var pais = new Pais(dto);

        report.setEnderecoId(endereco);
        endereco.getReportId().add(report);

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

        helperReport.setReportId(report);
        helperReport.setHelperId(helper);

        helperReportRepository.save(helperReport);
        reportRepository.save(report);
        return report;
    }

}
