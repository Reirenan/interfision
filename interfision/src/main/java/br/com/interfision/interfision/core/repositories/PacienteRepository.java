package br.com.interfision.interfision.core.repositories;

import br.com.interfision.interfision.core.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
