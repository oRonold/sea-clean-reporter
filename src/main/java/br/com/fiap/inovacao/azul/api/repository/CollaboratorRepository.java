package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.collaborator.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Long, Collaborator> {
}
