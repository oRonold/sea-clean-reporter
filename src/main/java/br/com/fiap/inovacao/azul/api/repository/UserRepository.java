package br.com.fiap.inovacao.azul.api.repository;

import br.com.fiap.inovacao.azul.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Long, User> {
}
