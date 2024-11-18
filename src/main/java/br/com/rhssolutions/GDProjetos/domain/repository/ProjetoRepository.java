package br.com.rhssolutions.GDProjetos.domain.repository;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
