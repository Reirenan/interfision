package br.com.interfision.interfision.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.interfision.interfision.core.models.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    
}
